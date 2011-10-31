package ventasautos

import org.apache.commons.collections.list.LazyList;
import org.apache.commons.collections.FactoryUtils;

class Vehiculo {

    String descripcion
    BigDecimal costo = new BigDecimal("0.00")
    BigDecimal costoVenta = new BigDecimal("0.00")
    Date fechaAlta = new Date()
    Date fechaVenta
    Boolean vendido = false
    List<Reparacion> reparaciones = new ArrayList<Reparacion>()
    
    static hasMany = [reparaciones : Reparacion]
    
    static constraints = {
        descripcion blank:false
        costo min:1.00, max:999999.00, scale:2, blank:false
        costoVenta min:1.00, max:999999.00, scale:2, blank:false
        reparaciones nullable:true
        fechaVenta nullable:true
    }

    static mapping = {
        reparaciones cascade: "all, delete-orphan"
    }

    def getExpandableReparacionesList() {
        return LazyList.decorate(reparaciones,FactoryUtils.instantiateFactory(Reparacion.class))
    }

    String toString(){
        return "costo: ${costo.toString()}, fechaAlta: ${fechaAlta}, vendido: ${vendido}"
    }
}
