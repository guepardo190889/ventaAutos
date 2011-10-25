package ventasautos



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(ReparacionController)
@Mock(Reparacion)
class ReparacionControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/reparacion/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.reparacionInstanceList.size() == 0
        assert model.reparacionInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.reparacionInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.reparacionInstance != null
        assert view == '/reparacion/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/reparacion/show/1'
        assert controller.flash.message != null
        assert Reparacion.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/reparacion/list'


        populateValidParams(params)
        def reparacion = new Reparacion(params)

        assert reparacion.save() != null

        params.id = reparacion.id

        def model = controller.show()

        assert model.reparacionInstance == reparacion
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/reparacion/list'


        populateValidParams(params)
        def reparacion = new Reparacion(params)

        assert reparacion.save() != null

        params.id = reparacion.id

        def model = controller.edit()

        assert model.reparacionInstance == reparacion
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/reparacion/list'

        response.reset()


        populateValidParams(params)
        def reparacion = new Reparacion(params)

        assert reparacion.save() != null

        // test invalid parameters in update
        params.id = reparacion.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/reparacion/edit"
        assert model.reparacionInstance != null

        reparacion.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/reparacion/show/$reparacion.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        reparacion.clearErrors()

        populateValidParams(params)
        params.id = reparacion.id
        params.version = -1
        controller.update()

        assert view == "/reparacion/edit"
        assert model.reparacionInstance != null
        assert model.reparacionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/reparacion/list'

        response.reset()

        populateValidParams(params)
        def reparacion = new Reparacion(params)

        assert reparacion.save() != null
        assert Reparacion.count() == 1

        params.id = reparacion.id

        controller.delete()

        assert Reparacion.count() == 0
        assert Reparacion.get(reparacion.id) == null
        assert response.redirectedUrl == '/reparacion/list'
    }
}
