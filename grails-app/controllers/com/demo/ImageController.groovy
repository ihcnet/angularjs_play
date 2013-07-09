package com.demo

import grails.plugin.gson.converters.GSON
import org.springframework.dao.DataIntegrityViolationException
import static javax.servlet.http.HttpServletResponse.*
import static org.codehaus.groovy.grails.web.servlet.HttpHeaders.*
import static grails.plugin.gson.http.HttpConstants.*

class ImageController {

    def index() {

    }

    def create() {
        render new Image() as GSON
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
		response.addIntHeader X_PAGINATION_TOTAL, Image.count()
		render Image.list(params) as GSON
	}

	def save() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def imageInstance = new Image(request.GSON)
		if (imageInstance.save(flush: true)) {
			respondCreated imageInstance
		} else {
			respondUnprocessableEntity imageInstance
		}
	}

	def get() {
		def imageInstance = Image.get(params.id)
		if (imageInstance) {
			respondFound imageInstance
		} else {
			respondNotFound params.id
		}
	}

	def update() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def imageInstance = Image.get(params.id)
		if (!imageInstance) {
			respondNotFound params.id
			return
		}

		if (params.version != null) {
			if (imageInstance.version > params.long('version')) {
				respondConflict(imageInstance)
				return
			}
		}

		imageInstance.properties = request.GSON

		if (imageInstance.save(flush: true)) {
			respondUpdated imageInstance
		} else {
			respondUnprocessableEntity imageInstance
		}
	}

	def delete() {
		def imageInstance = Image.get(params.id)
		if (!imageInstance) {
			respondNotFound params.id
			return
		}

		try {
			imageInstance.delete(flush: true)
			respondDeleted params.id
		} catch (DataIntegrityViolationException e) {
			respondNotDeleted params.id
		}
	}

	private boolean requestIsJson() {
		GSON.isJson(request)
	}

	private void respondFound(Image imageInstance) {
		response.status = SC_OK
		render imageInstance as GSON
	}

	private void respondUpdated(Image imageInstance) {
		response.status = SC_OK
		render imageInstance as GSON
	}

	private void respondDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.deleted.message', args: [message(code: 'image.label', default: 'Image'), id])
		response.status = SC_OK
		render responseBody as GSON
	}

	private void respondCreated(Image imageInstance) {
		response.status = SC_CREATED
		response.addHeader LOCATION, createLink(action: 'show', id: imageInstance.id)
		render imageInstance as GSON
	}

	private void respondNotFound(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.found.message', args: [message(code: 'image.label', default: 'Image'), id])
		response.status = SC_NOT_FOUND
		render responseBody as GSON
	}

	private void respondNotAcceptable() {
		response.status = SC_NOT_ACCEPTABLE
		response.contentLength = 0
		response.outputStream.flush()
		response.outputStream.close()
	}

	private void respondConflict(Image imageInstance) {
		imageInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
				[message(code: 'image.label', default: 'Image')] as Object[],
				'Another user has updated this Image while you were editing')
		def responseBody = [:]
		responseBody.errors = imageInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_CONFLICT
		render responseBody as GSON
	}

	private void respondUnprocessableEntity(Image imageInstance) {
		def responseBody = [:]
		responseBody.errors = imageInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_UNPROCESSABLE_ENTITY
		render responseBody as GSON
	}

	private void respondNotDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.deleted.message', args: [message(code: 'image.label', default: 'Image'), id])
		response.status = SC_INTERNAL_SERVER_ERROR
		render responseBody as GSON
	}

}
