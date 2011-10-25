package ventasautos

class Vehiculo {
    
    BigDecimal costo = new BigDecimal("0.00")
    BigDecimal costoVenta = new BigDecimal("0.00")
    Date fechaVenta
    Boolean vendido = false
    
    static hasMany = [reparaciones : Reparacion]
    
    static constraints = {
        
    }
}
