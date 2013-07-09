package com.demo

import grails.plugin.gson.converters.GSON
import org.springframework.dao.DataIntegrityViolationException
import static javax.servlet.http.HttpServletResponse.*
import static org.codehaus.groovy.grails.web.servlet.HttpHeaders.*
import static grails.plugin.gson.http.HttpConstants.*

class HardwareController {

    def index() {

    }

    def create() {
        render new Hardware() as GSON
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
		response.addIntHeader X_PAGINATION_TOTAL, Hardware.count()
		render Hardware.list(params) as GSON
	}

	def save() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def hardwareInstance = new Hardware(request.GSON)
		if (hardwareInstance.save(flush: true)) {
			respondCreated hardwareInstance
		} else {
			respondUnprocessableEntity hardwareInstance
		}
	}

	def get() {
		def hardwareInstance = Hardware.get(params.id)
		if (hardwareInstance) {
			respondFound hardwareInstance
		} else {
			respondNotFound params.id
		}
	}

	def update() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def hardwareInstance = Hardware.get(params.id)
		if (!hardwareInstance) {
			respondNotFound params.id
			return
		}

		if (params.version != null) {
			if (hardwareInstance.version > params.long('version')) {
				respondConflict(hardwareInstance)
				return
			}
		}

		hardwareInstance.properties = request.GSON

		if (hardwareInstance.save(flush: true)) {
			respondUpdated hardwareInstance
		} else {
			respondUnprocessableEntity hardwareInstance
		}
	}

	def delete() {
		def hardwareInstance = Hardware.get(params.id)
		if (!hardwareInstance) {
			respondNotFound params.id
			return
		}

		try {
			hardwareInstance.delete(flush: true)
			respondDeleted params.id
		} catch (DataIntegrityViolationException e) {
			respondNotDeleted params.id
		}
	}

	private boolean requestIsJson() {
		GSON.isJson(request)
	}

	private void respondFound(Hardware hardwareInstance) {
		response.status = SC_OK
		render hardwareInstance as GSON
	}

	private void respondUpdated(Hardware hardwareInstance) {
		response.status = SC_OK
		render hardwareInstance as GSON
	}

	private void respondDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.deleted.message', args: [message(code: 'hardware.label', default: 'Hardware'), id])
		response.status = SC_OK
		render responseBody as GSON
	}

	private void respondCreated(Hardware hardwareInstance) {
		response.status = SC_CREATED
		response.addHeader LOCATION, createLink(action: 'show', id: hardwareInstance.id)
		render hardwareInstance as GSON
	}

	private void respondNotFound(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.found.message', args: [message(code: 'hardware.label', default: 'Hardware'), id])
		response.status = SC_NOT_FOUND
		render responseBody as GSON
	}

	private void respondNotAcceptable() {
		response.status = SC_NOT_ACCEPTABLE
		response.contentLength = 0
		response.outputStream.flush()
		response.outputStream.close()
	}

	private void respondConflict(Hardware hardwareInstance) {
		hardwareInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
				[message(code: 'hardware.label', default: 'Hardware')] as Object[],
				'Another user has updated this Hardware while you were editing')
		def responseBody = [:]
		responseBody.errors = hardwareInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_CONFLICT
		render responseBody as GSON
	}

	private void respondUnprocessableEntity(Hardware hardwareInstance) {
		def responseBody = [:]
		responseBody.errors = hardwareInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_UNPROCESSABLE_ENTITY
		render responseBody as GSON
	}

	private void respondNotDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.deleted.message', args: [message(code: 'hardware.label', default: 'Hardware'), id])
		response.status = SC_INTERNAL_SERVER_ERROR
		render responseBody as GSON
	}

}
