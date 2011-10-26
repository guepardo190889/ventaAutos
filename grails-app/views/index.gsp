<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Venta de Autos</title>
                <!--<link type="text/css" href="menu.css" rel="stylesheet" />
        	<script type="text/javascript" src="jquery.js"></script>
                <script type="text/javascript" src="menu.js"></script>-->
	</head>
	<body>

<!--MENU START-->
        <div id="menu">
		<ul class="menu">
			<li>
                          <a href="${resource(dir: '')}" class="parent"><span>Inicio</span></a>
			</li>
			<li>
                          <a href="#"><span>Iglesias</span></a>
				<div><ul>
                                      <li><a href="iglesia/create"<span>Registrar Iglesia</span></a></li>
                                      <li><a href="#"<span><g:link class="iglesia" controller="iglesia"><g:message code="Lista de Iglesias" /></g:link></span></a></li>
                                  </ul></div>
			</li>
                        <li><a href="#"><span>Comunidad</span></a>
				<div><ul>
					<li><a href="persona/create"<span>Registrar Persona</span></a></li>
                                        <li><a href="persona/buscarPersona.gsp"<span>Buscar Persona</span></a></li>
                                        <li><a href="persona/list"><span>Lista de Personas</span></a></li>
					<li><a href="#"><span>Reportes</span></a>
                                        <div>
                                          <ul>
                                            <li><a href="persona/tipoSangre.gsp"><span>Tipo de Sangre</span></a>
                                            <li><a href="persona/buscarEdad.gsp"><span>Edades</span></a>
                                          </ul>
                                        </div>
                                        </li>
				</ul></div>
			</li>
                        <li><a href="#"><span>Miembros</span></a>
                            <div><ul>
                                <li><a href="persona/buscarMiembro.gsp"<span>Buscar Miembro</span></a></li>
                                <li><a href="#"><span>Reportes</span></a>
                                <div>
                                    <ul>
                                        <li><a href="#"<span><g:link class="persona" controller="persona" action="buscarMiembrosActivos"><g:message code="Miembros Activos" /></g:link></span></a></li>
                                        <li><a href="persona/reportes/buscarIngresos.gsp"<span>Buscar Ingresos</span></a></li>
<!--                                        <li><a href="#"><span>Libro de Iglesia</span></a>-->
                                    </ul>
                                </div>
                                </li>
                            </ul></div>
                        </li>
                        <li><a href="#"><span>Administración</span></a>
				<div><ul>
					<li><a href=""<span><g:link class="usuario" controller="usuario"><g:message code="Usuarios" /></g:link></span></a></li>
					
				</ul></div>
			</li>
			<li><a href="ayuda.gsp"><span>Ayuda</span></a></li>
		</ul>
        </div>
<!--MENU END-->

		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="page-body" role="main">
			<h1>Welcome to Grails</h1>
			<p>Congratulations, you have successfully started your first Grails application! At the moment
			   this is the default page, feel free to modify it to either redirect to a controller or display whatever
			   content you may choose. Below is a list of controllers that are currently deployed in this application,
			   click on each to execute its default action:</p>
		</div>
	</body>
</html>
