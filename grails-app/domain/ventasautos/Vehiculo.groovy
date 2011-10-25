package ventasautos

class Vehiculo {

    String descripcion
    BigDecimal costo = new BigDecimal("0.00")
    BigDecimal costoVenta = new BigDecimal("0.00")
    Date fechaAlta = new Date()
    Date fechaVenta
    Boolean vendido = false
    
    static hasMany = [reparaciones : Reparacion]
    
    static constraints = {
        descripcion blank:false
        costo blank:false
        costoVenta blank:false
    }

    String toString(){
        return "costo: ${costo.toString()}, fechaAlta: ${fechaAlta}, fechaVenta: ${fechaVenta}, vendido: ${vendido}"
    }
}
