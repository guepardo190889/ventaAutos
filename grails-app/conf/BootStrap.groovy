import login.*

class BootStrap {

    def init = { servletContext ->

    def springSecurityService
    def sessionFactory

        log.info "Creando Roles"
        def rolAdministrador = login.Rol.findByAuthority('ROLE_ADMINISTRADOR')
        if (!rolAdministrador) {
            rolAdministrador = new login.Rol(authority: 'ROLE_ADMINISTRADOR').save(flush:true)
        }
        def rolUsuario = login.Rol.findByAuthority('ROLE_USUARIO')
        if (!rolUsuario) {
            rolUsuario = new login.Rol(authority: 'ROLE_USUARIO').save(flush:true)
        }

        log.info "Creando Usuarios"
        def administrador = login.Usuario.findByUsername("blackdeath")
        if(!administrador){
            administrador = new login.Usuario(
                username:'blackdeath',
                password : 'aeiou123',
                enabled : true
            ).save(flush:true)
        }
        if (!administrador.authorities.contains(rolAdministrador)){
            UsuarioRol.create(administrador, rolAdministrador)
        }

        def usuario = login.Usuario.findByUsername("sklm")
        if(!usuario){
            usuario = new login.Usuario(
                username:'sklm',
                password : 'aeiou123',
                enabled : true
            ).save(flush:true)
        }
        if (!usuario.authorities.contains(rolUsuario)){
            UsuarioRol.create(usuario, rolUsuario)
        }

    }
    def destroy = {
    }
}
