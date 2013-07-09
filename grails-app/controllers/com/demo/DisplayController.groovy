package com.demo

import grails.plugin.gson.converters.GSON
import org.springframework.dao.DataIntegrityViolationException
import static javax.servlet.http.HttpServletResponse.*
import static org.codehaus.groovy.grails.web.servlet.HttpHeaders.*
import static grails.plugin.gson.http.HttpConstants.*

class DisplayController {

    def index() {

    }

    def create() {
        render new Display() as GSON
    }

    def createForm() {

    }

    def editForm() {

    }

    def listForm() {

    }

    def showForm() {

    }

	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		response.addIntHeader X_PAGINATION_TOTAL, Display.count()
		render Display.list(params) as GSON
	}

	def save() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def displayInstance = new Display(request.GSON)
		if (displayInstance.save(flush: true)) {
			respondCreated displayInstance
		} else {
			respondUnprocessableEntity displayInstance
		}
	}

	def get() {
		def displayInstance = Display.get(params.id)
		if (displayInstance) {
			respondFound displayInstance
		} else {
			respondNotFound params.id
		}
	}

	def update() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def displayInstance = Display.get(params.id)
		if (!displayInstance) {
			respondNotFound params.id
			return
		}

		if (params.version != null) {
			if (displayInstance.version > params.long('version')) {
				respondConflict(displayInstance)
				return
			}
		}

		displayInstance.properties = request.GSON

		if (displayInstance.save(flush: true)) {
			respondUpdated displayInstance
		} else {
			respondUnprocessableEntity displayInstance
		}
	}

	def delete() {
		def displayInstance = Display.get(params.id)
		if (!displayInstance) {
			respondNotFound params.id
			return
		}

		try {
			displayInstance.delete(flush: true)
			respondDeleted params.id
		} catch (DataIntegrityViolationException e) {
			respondNotDeleted params.id
		}
	}

	private boolean requestIsJson() {
		GSON.isJson(request)
	}

	private void respondFound(Display displayInstance) {
		response.status = SC_OK
		render displayInstance as GSON
	}

	private void respondUpdated(Display displayInstance) {
		response.status = SC_OK
		render displayInstance as GSON
	}

	private void respondDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.deleted.message', args: [message(code: 'display.label', default: 'Display'), id])
		response.status = SC_OK
		render responseBody as GSON
	}

	private void respondCreated(Display displayInstance) {
		response.status = SC_CREATED
		response.addHeader LOCATION, createLink(action: 'show', id: displayInstance.id)
		render displayInstance as GSON
	}

	private void respondNotFound(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.found.message', args: [message(code: 'display.label', default: 'Display'), id])
		response.status = SC_NOT_FOUND
		render responseBody as GSON
	}

	private void respondNotAcceptable() {
		response.status = SC_NOT_ACCEPTABLE
		response.contentLength = 0
		response.outputStream.flush()
		response.outputStream.close()
	}

	private void respondConflict(Display displayInstance) {
		displayInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
				[message(code: 'display.label', default: 'Display')] as Object[],
				'Another user has updated this Display while you were editing')
		def responseBody = [:]
		responseBody.errors = displayInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_CONFLICT
		render responseBody as GSON
	}

	private void respondUnprocessableEntity(Display displayInstance) {
		def responseBody = [:]
		responseBody.errors = displayInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_UNPROCESSABLE_ENTITY
		render responseBody as GSON
	}

	private void respondNotDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.deleted.message', args: [message(code: 'display.label', default: 'Display'), id])
		response.status = SC_INTERNAL_SERVER_ERROR
		render responseBody as GSON
	}

}
