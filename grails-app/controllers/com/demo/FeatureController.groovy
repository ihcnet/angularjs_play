package com.demo

import grails.plugin.gson.converters.GSON
import org.springframework.dao.DataIntegrityViolationException
import static javax.servlet.http.HttpServletResponse.*
import static org.codehaus.groovy.grails.web.servlet.HttpHeaders.*
import static grails.plugin.gson.http.HttpConstants.*

class FeatureController {

    def index() {

    }

    def create() {
        render new Feature() as GSON
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
		response.addIntHeader X_PAGINATION_TOTAL, Feature.count()
		render Feature.list(params) as GSON
	}

	def save() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def featureInstance = new Feature(request.GSON)
		if (featureInstance.save(flush: true)) {
			respondCreated featureInstance
		} else {
			respondUnprocessableEntity featureInstance
		}
	}

	def get() {
		def featureInstance = Feature.get(params.id)
		if (featureInstance) {
			respondFound featureInstance
		} else {
			respondNotFound params.id
		}
	}

	def update() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def featureInstance = Feature.get(params.id)
		if (!featureInstance) {
			respondNotFound params.id
			return
		}

		if (params.version != null) {
			if (featureInstance.version > params.long('version')) {
				respondConflict(featureInstance)
				return
			}
		}

		featureInstance.properties = request.GSON

		if (featureInstance.save(flush: true)) {
			respondUpdated featureInstance
		} else {
			respondUnprocessableEntity featureInstance
		}
	}

	def delete() {
		def featureInstance = Feature.get(params.id)
		if (!featureInstance) {
			respondNotFound params.id
			return
		}

		try {
			featureInstance.delete(flush: true)
			respondDeleted params.id
		} catch (DataIntegrityViolationException e) {
			respondNotDeleted params.id
		}
	}

	private boolean requestIsJson() {
		GSON.isJson(request)
	}

	private void respondFound(Feature featureInstance) {
		response.status = SC_OK
		render featureInstance as GSON
	}

	private void respondUpdated(Feature featureInstance) {
		response.status = SC_OK
		render featureInstance as GSON
	}

	private void respondDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.deleted.message', args: [message(code: 'feature.label', default: 'Feature'), id])
		response.status = SC_OK
		render responseBody as GSON
	}

	private void respondCreated(Feature featureInstance) {
		response.status = SC_CREATED
		response.addHeader LOCATION, createLink(action: 'show', id: featureInstance.id)
		render featureInstance as GSON
	}

	private void respondNotFound(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.found.message', args: [message(code: 'feature.label', default: 'Feature'), id])
		response.status = SC_NOT_FOUND
		render responseBody as GSON
	}

	private void respondNotAcceptable() {
		response.status = SC_NOT_ACCEPTABLE
		response.contentLength = 0
		response.outputStream.flush()
		response.outputStream.close()
	}

	private void respondConflict(Feature featureInstance) {
		featureInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
				[message(code: 'feature.label', default: 'Feature')] as Object[],
				'Another user has updated this Feature while you were editing')
		def responseBody = [:]
		responseBody.errors = featureInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_CONFLICT
		render responseBody as GSON
	}

	private void respondUnprocessableEntity(Feature featureInstance) {
		def responseBody = [:]
		responseBody.errors = featureInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_UNPROCESSABLE_ENTITY
		render responseBody as GSON
	}

	private void respondNotDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.deleted.message', args: [message(code: 'feature.label', default: 'Feature'), id])
		response.status = SC_INTERNAL_SERVER_ERROR
		render responseBody as GSON
	}

}
