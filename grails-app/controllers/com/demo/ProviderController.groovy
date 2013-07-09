package com.demo

import grails.plugin.gson.converters.GSON
import org.springframework.dao.DataIntegrityViolationException
import static javax.servlet.http.HttpServletResponse.*
import static org.codehaus.groovy.grails.web.servlet.HttpHeaders.*
import static grails.plugin.gson.http.HttpConstants.*

class ProviderController {

    def index() {

    }

    def create() {
        render new Provider() as GSON
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
		response.addIntHeader X_PAGINATION_TOTAL, Provider.count()
		render Provider.list(params) as GSON
	}

	def save() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def providerInstance = new Provider(request.GSON)
		if (providerInstance.save(flush: true)) {
			respondCreated providerInstance
		} else {
			respondUnprocessableEntity providerInstance
		}
	}

	def get() {
		def providerInstance = Provider.get(params.id)
		if (providerInstance) {
			respondFound providerInstance
		} else {
			respondNotFound params.id
		}
	}

	def update() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def providerInstance = Provider.get(params.id)
		if (!providerInstance) {
			respondNotFound params.id
			return
		}

		if (params.version != null) {
			if (providerInstance.version > params.long('version')) {
				respondConflict(providerInstance)
				return
			}
		}

		providerInstance.properties = request.GSON

		if (providerInstance.save(flush: true)) {
			respondUpdated providerInstance
		} else {
			respondUnprocessableEntity providerInstance
		}
	}

	def delete() {
		def providerInstance = Provider.get(params.id)
		if (!providerInstance) {
			respondNotFound params.id
			return
		}

		try {
			providerInstance.delete(flush: true)
			respondDeleted params.id
		} catch (DataIntegrityViolationException e) {
			respondNotDeleted params.id
		}
	}

	private boolean requestIsJson() {
		GSON.isJson(request)
	}

	private void respondFound(Provider providerInstance) {
		response.status = SC_OK
		render providerInstance as GSON
	}

	private void respondUpdated(Provider providerInstance) {
		response.status = SC_OK
		render providerInstance as GSON
	}

	private void respondDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.deleted.message', args: [message(code: 'provider.label', default: 'Provider'), id])
		response.status = SC_OK
		render responseBody as GSON
	}

	private void respondCreated(Provider providerInstance) {
		response.status = SC_CREATED
		response.addHeader LOCATION, createLink(action: 'show', id: providerInstance.id)
		render providerInstance as GSON
	}

	private void respondNotFound(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.found.message', args: [message(code: 'provider.label', default: 'Provider'), id])
		response.status = SC_NOT_FOUND
		render responseBody as GSON
	}

	private void respondNotAcceptable() {
		response.status = SC_NOT_ACCEPTABLE
		response.contentLength = 0
		response.outputStream.flush()
		response.outputStream.close()
	}

	private void respondConflict(Provider providerInstance) {
		providerInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
				[message(code: 'provider.label', default: 'Provider')] as Object[],
				'Another user has updated this Provider while you were editing')
		def responseBody = [:]
		responseBody.errors = providerInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_CONFLICT
		render responseBody as GSON
	}

	private void respondUnprocessableEntity(Provider providerInstance) {
		def responseBody = [:]
		responseBody.errors = providerInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_UNPROCESSABLE_ENTITY
		render responseBody as GSON
	}

	private void respondNotDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.deleted.message', args: [message(code: 'provider.label', default: 'Provider'), id])
		response.status = SC_INTERNAL_SERVER_ERROR
		render responseBody as GSON
	}

}
