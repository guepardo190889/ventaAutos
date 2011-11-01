package ventasautos

import grails.plugins.springsecurity.Secured

//@Secured(['ROLE_ADMINISTRADOR'])
class InicioController {

    def index = {
        def vehiculosList = Vehiculo.findAllByVendido(new Boolean(false))
//        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        render(view:"../vehiculo/vehiculosDisponibles",model:[vehiculoInstanceList: vehiculosList, vehiculoInstanceTotal: vehiculosList.size()])
    }

    def indexGeneral = {
        render(view:"../index")
    }

}
