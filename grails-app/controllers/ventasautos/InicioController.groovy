package ventasautos

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMINISTRADOR'])
class InicioController {

    def index = { }
}
