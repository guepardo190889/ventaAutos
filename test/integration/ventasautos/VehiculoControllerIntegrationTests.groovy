package ventasautos

import static org.junit.Assert.*
import org.junit.*

class VehiculoControllerIntegrationTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    List<Reparacion> crearReparaciones(Integer numReparaciones){
        List<Reparacion> reparaciones = new ArrayList<Reparacion>()
        for(int i = 1; i <= numReparaciones; i++){
            def reparacion = new Reparacion(
                descripcion : 'TEST',
                costo : new BigDecimal("0${i.toString()}.00")
            ).save()
            assertNotNull reparacion
            reparaciones.add(reparacion)
        }
        return reparaciones
    }

    @Test
    void debieraDarAltaUnVehiculo() {
        println "debieraDarAltaUnVehiculo"

        def controller = new VehiculoController()
        assert controller

        def model = controller.create()
        assert model
        assert model.vehiculoInstance

        def reparacionesList = crearReparaciones(5)

        controller.params.descripcion = "TEST"
        controller.params.costo = new BigDecimal("00.00")
        controller.params.costoVenta = new BigDecimal("00.00")
        controller.params.fechaAlta = new Date()
        controller.params.fechaVenta = new Date()
        controller.params.vendido = false
        controller.params.reparaciones = reparacionesList
        controller.save()

        assert controller.response.redirectedUrl.startsWith('/vehiculo/show')

        List<Vehiculo> vehiculos = Vehiculo.findAll()
        println "vehiculos: ${vehiculos.size()}"
        assertTrue vehiculos.size() > 0

        assertEquals "TEST" , vehiculos.get(0).descripcion
        assertEquals 5 , vehiculos.get(0).reparaciones.size()
        //assertEquals "1.00" , vehiculos.get(0).reparaciones.toList().get(0).costo.toString()

    }

    @Test
    void debieraModificarUnVehiculo() {
        println "debieraModificarUnVehiculo"

    	def vehiculo = new Vehiculo(
            descripcion : "TEST",
            costo : new BigDecimal("00.00"),
            costoVenta : new BigDecimal("00.00"),
            fechaVenta : new Date(),
            fechaAlta : new Date(),
            vendido : false
	).save()
        assertNotNull vehiculo

        def controller = new VehiculoController()
        controller.params.id = vehiculo.id

        def model = controller.show()
        assert model.vehiculoInstance
        assertEquals "TEST", model.vehiculoInstance.descripcion

        controller.params.id = vehiculo.id
        model = controller.edit()
        assert model.vehiculoInstance
        assertEquals "TEST", model.vehiculoInstance.descripcion

        controller.params.descripcion = 'TEST1'
        controller.update()
        println "response: ${controller.response.redirectedUrl}"
        assert controller.response.redirectedUrl.startsWith('/vehiculo/show')

        vehiculo.refresh()
        assertEquals 'TEST1', vehiculo.descripcion
    }

    @Test
    void debieraEliminarUnVehiculo() {
        println "eliminarUnVehiculo"

    	def vehiculo = new Vehiculo(
            descripcion : "TEST",
            costo : new BigDecimal("00.00"),
            costoVenta : new BigDecimal("00.00"),
            fechaVenta : new Date(),
            fechaAlta : new Date(),
            vendido : false
	).save()
        assertNotNull vehiculo

        def controller = new VehiculoController()
        controller.params.id = vehiculo.id

        def model = controller.show()
        assert model.vehiculoInstance
        assertEquals "TEST", model.vehiculoInstance.descripcion

        controller.params.id = vehiculo.id
        controller.delete()

        assert controller.response.redirectedUrl.startsWith("/vehiculo/list")

        model = Vehiculo.get(vehiculo.id)
        assert !model
    }
}
