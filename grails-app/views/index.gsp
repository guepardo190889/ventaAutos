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
			</ul>
		</div>
                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>
			<p>Felicidades. En este lugar, tu puedes registrar tu vehiculo para venderlo y tambien podras comprar otros vehiculos.
                        </br>
                        </br>
                        Ve al menu de Vehiculos, para registrar el tuyo</p>
		</div>
	</body>
</html>
