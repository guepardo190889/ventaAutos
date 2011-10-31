package ventasautos

class Reparacion {

    String descripcion
    BigDecimal costo = new BigDecimal("0.00")
//    Boolean _deleted

    static constraints = {
        descripcion blank:false
    }

//    static transients = [ '_deleted' ]

    static belongsTo = [ vehiculo:Vehiculo ]

    def String toString() {
        return descripcion
    }
}
