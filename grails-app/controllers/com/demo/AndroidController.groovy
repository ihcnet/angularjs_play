package com.demo

import grails.plugin.gson.converters.GSON
import org.springframework.dao.DataIntegrityViolationException
import static javax.servlet.http.HttpServletResponse.*
import static org.codehaus.groovy.grails.web.servlet.HttpHeaders.*
import static grails.plugin.gson.http.HttpConstants.*

class AndroidController {

    def index() {

    }

    def create() {
        render new Android() as GSON
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
		response.addIntHeader X_PAGINATION_TOTAL, Android.count()
		render Android.list(params) as GSON
	}

	def save() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def androidInstance = new Android(request.GSON)
		if (androidInstance.save(flush: true)) {
			respondCreated androidInstance
		} else {
			respondUnprocessableEntity androidInstance
		}
	}

	def get() {
		def androidInstance = Android.get(params.id)
		if (androidInstance) {
			respondFound androidInstance
		} else {
			respondNotFound params.id
		}
	}

	def update() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def androidInstance = Android.get(params.id)
		if (!androidInstance) {
			respondNotFound params.id
			return
		}

		if (params.version != null) {
			if (androidInstance.version > params.long('version')) {
				respondConflict(androidInstance)
				return
			}
		}

		androidInstance.properties = request.GSON

		if (androidInstance.save(flush: true)) {
			respondUpdated androidInstance
		} else {
			respondUnprocessableEntity androidInstance
		}
	}

	def delete() {
		def androidInstance = Android.get(params.id)
		if (!androidInstance) {
			respondNotFound params.id
			return
		}

		try {
			androidInstance.delete(flush: true)
			respondDeleted params.id
		} catch (DataIntegrityViolationException e) {
			respondNotDeleted params.id
		}
	}

	private boolean requestIsJson() {
		GSON.isJson(request)
	}

	private void respondFound(Android androidInstance) {
		response.status = SC_OK
		render androidInstance as GSON
	}

	private void respondUpdated(Android androidInstance) {
		response.status = SC_OK
		render androidInstance as GSON
	}

	private void respondDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.deleted.message', args: [message(code: 'android.label', default: 'Android'), id])
		response.status = SC_OK
		render responseBody as GSON
	}

	private void respondCreated(Android androidInstance) {
		response.status = SC_CREATED
		response.addHeader LOCATION, createLink(action: 'show', id: androidInstance.id)
		render androidInstance as GSON
	}

	private void respondNotFound(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.found.message', args: [message(code: 'android.label', default: 'Android'), id])
		response.status = SC_NOT_FOUND
		render responseBody as GSON
	}

	private void respondNotAcceptable() {
		response.status = SC_NOT_ACCEPTABLE
		response.contentLength = 0
		response.outputStream.flush()
		response.outputStream.close()
	}

	private void respondConflict(Android androidInstance) {
		androidInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
				[message(code: 'android.label', default: 'Android')] as Object[],
				'Another user has updated this Android while you were editing')
		def responseBody = [:]
		responseBody.errors = androidInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_CONFLICT
		render responseBody as GSON
	}

	private void respondUnprocessableEntity(Android androidInstance) {
		def responseBody = [:]
		responseBody.errors = androidInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_UNPROCESSABLE_ENTITY
		render responseBody as GSON
	}

	private void respondNotDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.deleted.message', args: [message(code: 'android.label', default: 'Android'), id])
		response.status = SC_INTERNAL_SERVER_ERROR
		render responseBody as GSON
	}

}
