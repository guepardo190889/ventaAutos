package ventasautos

class Reparacion {

    String descripcion
    BigDecimal costo = new BigDecimal("0.00")
    
    static constraints = {
        descripcion blank:false
    }
}
