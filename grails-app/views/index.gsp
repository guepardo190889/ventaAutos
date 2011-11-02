<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Venta de Autos</title>
	</head>
	<body>
            <a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
            <div id="page-body" role="main">
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/>&nbsp;&gt;</a></li>
				<li><g:link class="list" controller="vehiculo" action="vehiculosDisponibles"><g:message code="vehiculo.list.disponibles.label" /></g:link></li>
                                <li><g:link class="list" controller="vehiculo" action="vehiculosVendidos"><g:message code="vehiculo.list.vendidos.label" /></g:link></li>
                                <sec:ifAllGranted roles="ROLE_VENDEDOR">
                                  <li><g:link class="list" controller="vehiculo" action="create"><g:message code="vehiculo.registrarVehiculo.label" /></g:link></li>
                                <li><g:link class="list" controller="vehiculo" action="misVehiculosEnVenta"><g:message code="vehiculo.misvehiculos.label" /></g:link></li>
                                </sec:ifAllGranted>
			</ul>
		</div>
                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>
			<p>En este lugar, tu puedes registrar tu vehiculo para venderlo y tambien podras comprar otros vehiculos.
                        </br>
                        </br>
                        Navega por los menus para conocer las diferentes opciones</p>
		</div>
	</body>
</html>
