package com.demo

import grails.plugin.gson.converters.GSON
import org.springframework.dao.DataIntegrityViolationException
import static javax.servlet.http.HttpServletResponse.*
import static org.codehaus.groovy.grails.web.servlet.HttpHeaders.*
import static grails.plugin.gson.http.HttpConstants.*

class PhoneController {

    def index() {

    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        response.addIntHeader X_PAGINATION_TOTAL, Phone.count()
        render Phone.list(params) as GSON
    }

    def save() {
        if (!requestIsJson()) {
            respondNotAcceptable()
            return
        }

        def phoneInstance = new Phone(request.GSON)
        if (phoneInstance.save(flush: true)) {
            respondCreated phoneInstance
        } else {
            respondUnprocessableEntity phoneInstance
        }
    }

    def get() {
        def phoneInstance = Phone.get(params.id)
        if (phoneInstance) {
            respondFound phoneInstance
        } else {
            respondNotFound params.id
        }
    }

    def update() {
        if (!requestIsJson()) {
            respondNotAcceptable()
            return
        }

        def phoneInstance = Phone.get(params.id)
        if (!phoneInstance) {
            respondNotFound params.id
            return
        }

        if (params.version != null) {
            if (phoneInstance.version > params.long('version')) {
                respondConflict(phoneInstance)
                return
            }
        }

        phoneInstance.properties = request.GSON

        if (phoneInstance.save(flush: true)) {
            respondUpdated phoneInstance
        } else {
            respondUnprocessableEntity phoneInstance
        }
    }

    def delete() {
        def phoneInstance = Phone.get(params.id)
        if (!phoneInstance) {
            respondNotFound params.id
            return
        }

        try {
            phoneInstance.delete(flush: true)
            respondDeleted params.id
        } catch (DataIntegrityViolationException e) {
            respondNotDeleted params.id
        }
    }

    private boolean requestIsJson() {
        GSON.isJson(request)
    }

    private void respondFound(Phone phoneInstance) {
        response.status = SC_OK
        render phoneInstance as GSON
    }

    private void respondUpdated(Phone phoneInstance) {
        response.status = SC_OK
        render phoneInstance as GSON
    }

    private void respondDeleted(id) {
        def responseBody = [:]
        responseBody.message = message(code: 'default.deleted.message', args: [message(code: 'phone.label', default: 'Phone'), id])
        response.status = SC_OK
        render responseBody as GSON
    }

    private void respondCreated(Phone phoneInstance) {
        response.status = SC_CREATED
        response.addHeader LOCATION, createLink(action: 'show', id: phoneInstance.id)
        render phoneInstance as GSON
    }

    private void respondNotFound(id) {
        def responseBody = [:]
        responseBody.message = message(code: 'default.not.found.message', args: [message(code: 'phone.label', default: 'Phone'), id])
        response.status = SC_NOT_FOUND
        render responseBody as GSON
    }

    private void respondNotAcceptable() {
        response.status = SC_NOT_ACCEPTABLE
        response.contentLength = 0
        response.outputStream.flush()
        response.outputStream.close()
    }

    private void respondConflict(Phone phoneInstance) {
        phoneInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
                [message(code: 'phone.label', default: 'Phone')] as Object[],
                'Another user has updated this Phone while you were editing')
        def responseBody = [:]
        responseBody.errors = phoneInstance.errors.allErrors.collect {
            message(error: it)
        }
        response.status = SC_CONFLICT
        render responseBody as GSON
    }

    private void respondUnprocessableEntity(Phone phoneInstance) {
        def responseBody = [:]
        responseBody.errors = phoneInstance.errors.allErrors.collect {
            message(error: it)
        }
        response.status = SC_UNPROCESSABLE_ENTITY
        render responseBody as GSON
    }

    private void respondNotDeleted(id) {
        def responseBody = [:]
        responseBody.message = message(code: 'default.not.deleted.message', args: [message(code: 'phone.label', default: 'Phone'), id])
        response.status = SC_INTERNAL_SERVER_ERROR
        render responseBody as GSON
    }

}
