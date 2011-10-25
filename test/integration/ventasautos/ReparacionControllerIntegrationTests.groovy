package ventasautos

import static org.junit.Assert.*
import org.junit.*

class ReparacionControllerIntegrationTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void debieraDarAltaUnaReparacion() {
        println "debieraDarAltaUnaReparacion"

        def controller = new ReparacionController()
        assert controller

        def model = controller.create()
        assert model
        assert model.reparacionInstance

        controller.params.descripcion = 'TEST'
        controller.params.costo = new BigDecimal("00.00")
        controller.save()

        assert controller.response.redirectedUrl.startsWith('/reparacion/show')

        List<Reparacion> reparaciones = Reparacion.findAll()
        println "reparaciones: ${reparaciones.size()}"
        assertTrue reparaciones.size() > 0

        assertEquals "TEST" , reparaciones.get(0).descripcion

    }

    @Test
    void debieraModificarUnaReparacion() {
        println "debieraModificarUnaReparacion"

    	def reparacion = new Reparacion(
            descripcion : 'TEST',
            costo : new BigDecimal("00.00")
	).save()
        assertNotNull reparacion

        def controller = new ReparacionController()
        controller.params.id = reparacion.id

        def model = controller.show()
        assert model.reparacionInstance
        assertEquals "TEST", model.reparacionInstance.descripcion

        controller.params.id = reparacion.id
        model = controller.edit()
        assert model.reparacionInstance
        assertEquals "TEST", model.reparacionInstance.descripcion

        controller.params.descripcion = 'TEST1'
        controller.update()
        println "response: ${controller.response.redirectedUrl}"
        assert controller.response.redirectedUrl.startsWith('/reparacion/show')

        reparacion.refresh()
        assertEquals 'TEST1', reparacion.descripcion
    }

    @Test
    void debieraEliminarUnReparacion() {
        println "eliminarReparacion"

    	def reparacion = new Reparacion(
            descripcion : 'TEST',
            costo : new BigDecimal("00.00")
        ).save()
	assertNotNull reparacion

        def controller = new ReparacionController()
        controller.params.id = reparacion.id

        def model = controller.show()
        assert model.reparacionInstance
        assertEquals "TEST", model.reparacionInstance.descripcion

        controller.params.id = reparacion.id
        controller.delete()

        assert controller.response.redirectedUrl.startsWith("/reparacion/list")

        model = Reparacion.get(reparacion.id)
        assert !model
    }
}
