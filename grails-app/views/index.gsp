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
				<li><g:link class="list" controller="vehiculo"><g:message code="vehiculo.list.label" /></g:link></li>
<!--				<li><g:link class="list" controller="tipoCliente"><g:message code="tipoCliente.list.label" /></g:link></li>
				<li><g:link class="list" controller="proveedor"><g:message code="proveedor.list.label" /></g:link></li>
				<li><g:link class="list" controller="usuario"><g:message code="usuario.list.label" /></g:link></li>
				<li><g:link class="list" controller="empresa"><g:message code="empresa.list.label" /></g:link></li>
				<li><g:link class="list" controller="organizacion"><g:message code="organizacion.list.label" /></g:link></li>-->
			</ul>
		</div>
                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>

<!--                <div class="content">
                  <h1><g:message code="admin.label" default="Admin" /></h1>
                </div>-->

                
<!--			<h1>Bienvenido!</h1>-->
			<p>Felicidades. En este lugar, tu puedes registrar tu vehiculo para venderlo y tambien podras comprar otros vehiculos.
                        </br>
                        </br>
                        Ve al menu de Vehiculos, para registrar el tuyo</p>
		</div>
	</body>
</html>
