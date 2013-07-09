package com.demo

import grails.plugin.gson.converters.GSON
import org.springframework.dao.DataIntegrityViolationException
import static javax.servlet.http.HttpServletResponse.*
import static org.codehaus.groovy.grails.web.servlet.HttpHeaders.*
import static grails.plugin.gson.http.HttpConstants.*

class ConnectivityController {

    def index() {

    }

    def create() {
        render new Connectivity() as GSON
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
		response.addIntHeader X_PAGINATION_TOTAL, Connectivity.count()
		render Connectivity.list(params) as GSON
	}

	def save() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def connectivityInstance = new Connectivity(request.GSON)
		if (connectivityInstance.save(flush: true)) {
			respondCreated connectivityInstance
		} else {
			respondUnprocessableEntity connectivityInstance
		}
	}

	def get() {
		def connectivityInstance = Connectivity.get(params.id)
		if (connectivityInstance) {
			respondFound connectivityInstance
		} else {
			respondNotFound params.id
		}
	}

	def update() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def connectivityInstance = Connectivity.get(params.id)
		if (!connectivityInstance) {
			respondNotFound params.id
			return
		}

		if (params.version != null) {
			if (connectivityInstance.version > params.long('version')) {
				respondConflict(connectivityInstance)
				return
			}
		}

		connectivityInstance.properties = request.GSON

		if (connectivityInstance.save(flush: true)) {
			respondUpdated connectivityInstance
		} else {
			respondUnprocessableEntity connectivityInstance
		}
	}

	def delete() {
		def connectivityInstance = Connectivity.get(params.id)
		if (!connectivityInstance) {
			respondNotFound params.id
			return
		}

		try {
			connectivityInstance.delete(flush: true)
			respondDeleted params.id
		} catch (DataIntegrityViolationException e) {
			respondNotDeleted params.id
		}
	}

	private boolean requestIsJson() {
		GSON.isJson(request)
	}

	private void respondFound(Connectivity connectivityInstance) {
		response.status = SC_OK
		render connectivityInstance as GSON
	}

	private void respondUpdated(Connectivity connectivityInstance) {
		response.status = SC_OK
		render connectivityInstance as GSON
	}

	private void respondDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.deleted.message', args: [message(code: 'connectivity.label', default: 'Connectivity'), id])
		response.status = SC_OK
		render responseBody as GSON
	}

	private void respondCreated(Connectivity connectivityInstance) {
		response.status = SC_CREATED
		response.addHeader LOCATION, createLink(action: 'show', id: connectivityInstance.id)
		render connectivityInstance as GSON
	}

	private void respondNotFound(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.found.message', args: [message(code: 'connectivity.label', default: 'Connectivity'), id])
		response.status = SC_NOT_FOUND
		render responseBody as GSON
	}

	private void respondNotAcceptable() {
		response.status = SC_NOT_ACCEPTABLE
		response.contentLength = 0
		response.outputStream.flush()
		response.outputStream.close()
	}

	private void respondConflict(Connectivity connectivityInstance) {
		connectivityInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
				[message(code: 'connectivity.label', default: 'Connectivity')] as Object[],
				'Another user has updated this Connectivity while you were editing')
		def responseBody = [:]
		responseBody.errors = connectivityInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_CONFLICT
		render responseBody as GSON
	}

	private void respondUnprocessableEntity(Connectivity connectivityInstance) {
		def responseBody = [:]
		responseBody.errors = connectivityInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_UNPROCESSABLE_ENTITY
		render responseBody as GSON
	}

	private void respondNotDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.deleted.message', args: [message(code: 'connectivity.label', default: 'Connectivity'), id])
		response.status = SC_INTERNAL_SERVER_ERROR
		render responseBody as GSON
	}

}
