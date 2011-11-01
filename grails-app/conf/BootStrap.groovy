import login.*
import ventasautos.*

class BootStrap {

    def init = { servletContext ->

    def springSecurityService
    def sessionFactory

        log.info "Creando Roles"
        def rolAdministrador = login.Rol.findByAuthority('ROLE_ADMINISTRADOR')
        if (!rolAdministrador) {
            rolAdministrador = new login.Rol(authority: 'ROLE_ADMINISTRADOR').save(flush:true)
        }
        def rolVendedor = login.Rol.findByAuthority('ROLE_VENDEDOR')
        if (!rolVendedor) {
            rolVendedor = new login.Rol(authority: 'ROLE_VENDEDOR').save(flush:true)
        }

        log.info "Creando Usuarios"
        def administrador = login.Usuario.findByUsername("blackdeath")
        if(!administrador){
            administrador = new login.Usuario(
                nombre : 'Seth Karim',
                apellidoPaterno : 'Luis',
                apellidoMaterno : 'Martinez',
                direccion: 'Dormi 3',
                telefono : '8261130554',
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
                nombre : 'Seth Karim',
                apellidoPaterno : 'Luis',
                apellidoMaterno : 'Martinez',
                direccion: 'Dormi 3',
                telefono : '8261130555',
                username:'sklm',
                password : 'aeiou123',
                enabled : true
            ).save(flush:true)
        }
        if (!usuario.authorities.contains(rolVendedor)){
            UsuarioRol.create(usuario, rolVendedor)
        }

        log.debug 'Creando Vehiculos de Prueba'
        def vehiculo = new Vehiculo(
            descripcion : 'Altima',
            modelo : '1999',
            marca : 'Nissan',
            costo : new BigDecimal("35000.00"),
            costoVenta : new BigDecimal("30000.00"),
            fechaAlta : new Date(),
            vendido : false
        ).save(flush:true)

        def vehiculo2 = new Vehiculo(
            descripcion : 'Jetta',
            modelo : '2011',
            marca : 'Nissan',
            costo : new BigDecimal("85000.00"),
            costoVenta : new BigDecimal("70000.00"),
            fechaAlta : new Date(),
            vendido : false
        ).save(flush:true)

        def vehiculo3 = new Vehiculo(
            descripcion : 'Bocho',
            modelo : '1998',
            marca : 'Volkswagen',
            costo : new BigDecimal("35000.00"),
            costoVenta : new BigDecimal("10000.00"),
            fechaAlta : new Date(),
            vendido : true
        ).save(flush:true)

    }
    def destroy = {
    }
}
