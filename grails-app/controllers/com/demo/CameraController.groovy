package com.demo

import grails.plugin.gson.converters.GSON
import org.springframework.dao.DataIntegrityViolationException
import static javax.servlet.http.HttpServletResponse.*
import static org.codehaus.groovy.grails.web.servlet.HttpHeaders.*
import static grails.plugin.gson.http.HttpConstants.*

class CameraController {

    def index() {

    }

    def create() {
        render new Camera() as GSON
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
		response.addIntHeader X_PAGINATION_TOTAL, Camera.count()
		render Camera.list(params) as GSON
	}

	def save() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def cameraInstance = new Camera(request.GSON)
		if (cameraInstance.save(flush: true)) {
			respondCreated cameraInstance
		} else {
			respondUnprocessableEntity cameraInstance
		}
	}

	def get() {
		def cameraInstance = Camera.get(params.id)
		if (cameraInstance) {
			respondFound cameraInstance
		} else {
			respondNotFound params.id
		}
	}

	def update() {
		if (!requestIsJson()) {
			respondNotAcceptable()
			return
		}

		def cameraInstance = Camera.get(params.id)
		if (!cameraInstance) {
			respondNotFound params.id
			return
		}

		if (params.version != null) {
			if (cameraInstance.version > params.long('version')) {
				respondConflict(cameraInstance)
				return
			}
		}

		cameraInstance.properties = request.GSON

		if (cameraInstance.save(flush: true)) {
			respondUpdated cameraInstance
		} else {
			respondUnprocessableEntity cameraInstance
		}
	}

	def delete() {
		def cameraInstance = Camera.get(params.id)
		if (!cameraInstance) {
			respondNotFound params.id
			return
		}

		try {
			cameraInstance.delete(flush: true)
			respondDeleted params.id
		} catch (DataIntegrityViolationException e) {
			respondNotDeleted params.id
		}
	}

	private boolean requestIsJson() {
		GSON.isJson(request)
	}

	private void respondFound(Camera cameraInstance) {
		response.status = SC_OK
		render cameraInstance as GSON
	}

	private void respondUpdated(Camera cameraInstance) {
		response.status = SC_OK
		render cameraInstance as GSON
	}

	private void respondDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.deleted.message', args: [message(code: 'camera.label', default: 'Camera'), id])
		response.status = SC_OK
		render responseBody as GSON
	}

	private void respondCreated(Camera cameraInstance) {
		response.status = SC_CREATED
		response.addHeader LOCATION, createLink(action: 'show', id: cameraInstance.id)
		render cameraInstance as GSON
	}

	private void respondNotFound(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.found.message', args: [message(code: 'camera.label', default: 'Camera'), id])
		response.status = SC_NOT_FOUND
		render responseBody as GSON
	}

	private void respondNotAcceptable() {
		response.status = SC_NOT_ACCEPTABLE
		response.contentLength = 0
		response.outputStream.flush()
		response.outputStream.close()
	}

	private void respondConflict(Camera cameraInstance) {
		cameraInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
				[message(code: 'camera.label', default: 'Camera')] as Object[],
				'Another user has updated this Camera while you were editing')
		def responseBody = [:]
		responseBody.errors = cameraInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_CONFLICT
		render responseBody as GSON
	}

	private void respondUnprocessableEntity(Camera cameraInstance) {
		def responseBody = [:]
		responseBody.errors = cameraInstance.errors.allErrors.collect {
			message(error: it)
		}
		response.status = SC_UNPROCESSABLE_ENTITY
		render responseBody as GSON
	}

	private void respondNotDeleted(id) {
		def responseBody = [:]
		responseBody.message = message(code: 'default.not.deleted.message', args: [message(code: 'camera.label', default: 'Camera'), id])
		response.status = SC_INTERNAL_SERVER_ERROR
		render responseBody as GSON
	}

}
