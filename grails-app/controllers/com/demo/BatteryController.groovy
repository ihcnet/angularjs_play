package com.demo

import grails.plugin.gson.converters.GSON
import org.springframework.dao.DataIntegrityViolationException
import static javax.servlet.http.HttpServletResponse.*
import static org.codehaus.groovy.grails.web.servlet.HttpHeaders.*
import static grails.plugin.gson.http.HttpConstants.*

class BatteryController {

    def index() {

    }

    def create() {
        render new Battery() as GSON
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
		response.addIntHeader X_PAGINATION_TOTAL, Battery.count()
		render Battery.list(params) as GSON
	}

	def save() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def batteryInstance = new Battery(request.GSON)
		if (batteryInstance.save(flush: true)) {
			respondCreated batteryInstance
		} else {
			respondUnprocessableEntity batteryInstance
		}
	}

	def get() {
		def batteryInstance = Battery.get(params.id)
		if (batteryInstance) {
			respondFound batteryInstance
		} else {
			respondNotFound params.id
		}
	}

	def update() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def batteryInstance = Battery.get(params.id)
		if (!batteryInstance) {
			respondNotFound params.id
			return
		}

		if (params.version != null) {
			if (batteryInstance.version > params.long('version')) {
				respondConflict(batteryInstance)
				return
			}
		}

		batteryInstance.properties = request.GSON

		if (batteryInstance.save(flush: true)) {
			respondUpdated batteryInstance
		} else {
			respondUnprocessableEntity batteryInstance
		}
	}

	def delete() {
		def batteryInstance = Battery.get(params.id)
		if (!batteryInstance) {
			respondNotFound params.id
			return
		}

		try {
			batteryInstance.delete(flush: true)
			respondDeleted params.id
		} catch (DataIntegrityViolationException e) {
			respondNotDeleted params.id
		}
	}

	private boolean requestIsJson() {
		GSON.isJson(request)
	}

	private void respondFound(Battery batteryInstance) {
		response.status = SC_OK
		render batteryInstance as GSON
	}

	private void respondUpdated(Battery batteryInstance) {
		response.status = SC_OK
		render batteryInstance as GSON
	}

	private void respondDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.deleted.message', args: [message(code: 'battery.label', default: 'Battery'), id])
		response.status = SC_OK
		render responseBody as GSON
	}

	private void respondCreated(Battery batteryInstance) {
		response.status = SC_CREATED
		response.addHeader LOCATION, createLink(action: 'show', id: batteryInstance.id)
		render batteryInstance as GSON
	}

	private void respondNotFound(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.found.message', args: [message(code: 'battery.label', default: 'Battery'), id])
		response.status = SC_NOT_FOUND
		render responseBody as GSON
	}

	private void respondNotAcceptable() {
		response.status = SC_NOT_ACCEPTABLE
		response.contentLength = 0
		response.outputStream.flush()
		response.outputStream.close()
	}

	private void respondConflict(Battery batteryInstance) {
		batteryInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
				[message(code: 'battery.label', default: 'Battery')] as Object[],
				'Another user has updated this Battery while you were editing')
		def responseBody = [:]
		responseBody.errors = batteryInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_CONFLICT
		render responseBody as GSON
	}

	private void respondUnprocessableEntity(Battery batteryInstance) {
		def responseBody = [:]
		responseBody.errors = batteryInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_UNPROCESSABLE_ENTITY
		render responseBody as GSON
	}

	private void respondNotDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.deleted.message', args: [message(code: 'battery.label', default: 'Battery'), id])
		response.status = SC_INTERNAL_SERVER_ERROR
		render responseBody as GSON
	}

}
