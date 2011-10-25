package ventasautos

import org.springframework.dao.DataIntegrityViolationException

class ReparacionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [reparacionInstanceList: Reparacion.list(params), reparacionInstanceTotal: Reparacion.count()]
    }

    def create() {
        [reparacionInstance: new Reparacion(params)]
    }

    def save() {
        def reparacionInstance = new Reparacion(params)
        if (!reparacionInstance.save(flush: true)) {
            render(view: "create", model: [reparacionInstance: reparacionInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'reparacion.label', default: 'Reparacion'), reparacionInstance.id])
        redirect(action: "show", id: reparacionInstance.id)
    }

    def show() {
        def reparacionInstance = Reparacion.get(params.id)
        if (!reparacionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'reparacion.label', default: 'Reparacion'), params.id])
            redirect(action: "list")
            return
        }

        [reparacionInstance: reparacionInstance]
    }

    def edit() {
        def reparacionInstance = Reparacion.get(params.id)
        if (!reparacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reparacion.label', default: 'Reparacion'), params.id])
            redirect(action: "list")
            return
        }

        [reparacionInstance: reparacionInstance]
    }

    def update() {
        def reparacionInstance = Reparacion.get(params.id)
        if (!reparacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reparacion.label', default: 'Reparacion'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (reparacionInstance.version > version) {
                reparacionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'reparacion.label', default: 'Reparacion')] as Object[],
                          "Another user has updated this Reparacion while you were editing")
                render(view: "edit", model: [reparacionInstance: reparacionInstance])
                return
            }
        }

        reparacionInstance.properties = params

        if (!reparacionInstance.save(flush: true)) {
            render(view: "edit", model: [reparacionInstance: reparacionInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'reparacion.label', default: 'Reparacion'), reparacionInstance.id])
        redirect(action: "show", id: reparacionInstance.id)
    }

    def delete() {
        def reparacionInstance = Reparacion.get(params.id)
        if (!reparacionInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'reparacion.label', default: 'Reparacion'), params.id])
            redirect(action: "list")
            return
        }

        try {
            reparacionInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'reparacion.label', default: 'Reparacion'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'reparacion.label', default: 'Reparacion'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
