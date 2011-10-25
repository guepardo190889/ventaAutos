package ventasautos



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(VehiculoController)
@Mock(Vehiculo)
class VehiculoControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/vehiculo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.vehiculoInstanceList.size() == 0
        assert model.vehiculoInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.vehiculoInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.vehiculoInstance != null
        assert view == '/vehiculo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/vehiculo/show/1'
        assert controller.flash.message != null
        assert Vehiculo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/vehiculo/list'


        populateValidParams(params)
        def vehiculo = new Vehiculo(params)

        assert vehiculo.save() != null

        params.id = vehiculo.id

        def model = controller.show()

        assert model.vehiculoInstance == vehiculo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/vehiculo/list'


        populateValidParams(params)
        def vehiculo = new Vehiculo(params)

        assert vehiculo.save() != null

        params.id = vehiculo.id

        def model = controller.edit()

        assert model.vehiculoInstance == vehiculo
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/vehiculo/list'

        response.reset()


        populateValidParams(params)
        def vehiculo = new Vehiculo(params)

        assert vehiculo.save() != null

        // test invalid parameters in update
        params.id = vehiculo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/vehiculo/edit"
        assert model.vehiculoInstance != null

        vehiculo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/vehiculo/show/$vehiculo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        vehiculo.clearErrors()

        populateValidParams(params)
        params.id = vehiculo.id
        params.version = -1
        controller.update()

        assert view == "/vehiculo/edit"
        assert model.vehiculoInstance != null
        assert model.vehiculoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/vehiculo/list'

        response.reset()

        populateValidParams(params)
        def vehiculo = new Vehiculo(params)

        assert vehiculo.save() != null
        assert Vehiculo.count() == 1

        params.id = vehiculo.id

        controller.delete()

        assert Vehiculo.count() == 0
        assert Vehiculo.get(vehiculo.id) == null
        assert response.redirectedUrl == '/vehiculo/list'
    }
}
