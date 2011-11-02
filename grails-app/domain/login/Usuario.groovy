package login
import ventasautos.Vehiculo

class Usuario {

	transient springSecurityService

	String username
	String password
        String nombre
        String apellidoPaterno
        String apellidoMaterno
        String direccion
        String telefono
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
        List<Vehiculo> vehiculos

        static hasMany = [vehiculos : Vehiculo]

	static constraints = {
            vehiculos nullable:true
            username blank: false, unique: true
            password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Rol> getAuthorities() {
		UsuarioRol.findAllByUsuario(this).collect { it.rol } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
