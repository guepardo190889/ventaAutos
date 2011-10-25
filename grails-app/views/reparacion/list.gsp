
<%@ page import="ventasautos.Reparacion" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reparacion.label', default: 'Reparacion')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-reparacion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-reparacion" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="descripcion" title="${message(code: 'reparacion.descripcion.label', default: 'Descripcion')}" />
					
						<g:sortableColumn property="costo" title="${message(code: 'reparacion.costo.label', default: 'Costo')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${reparacionInstanceList}" status="i" var="reparacionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${reparacionInstance.id}">${fieldValue(bean: reparacionInstance, field: "descripcion")}</g:link></td>
					
						<td>${fieldValue(bean: reparacionInstance, field: "costo")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${reparacionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
