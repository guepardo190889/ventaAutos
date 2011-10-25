
<%@ page import="ventasautos.Vehiculo" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vehiculo.label', default: 'Vehiculo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-vehiculo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-vehiculo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list vehiculo">
			
				<g:if test="${vehiculoInstance?.costo}">
				<li class="fieldcontain">
					<span id="costo-label" class="property-label"><g:message code="vehiculo.costo.label" default="Costo" /></span>
					
						<span class="property-value" aria-labelledby="costo-label"><g:fieldValue bean="${vehiculoInstance}" field="costo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.costoVenta}">
				<li class="fieldcontain">
					<span id="costoVenta-label" class="property-label"><g:message code="vehiculo.costoVenta.label" default="Costo Venta" /></span>
					
						<span class="property-value" aria-labelledby="costoVenta-label"><g:fieldValue bean="${vehiculoInstance}" field="costoVenta"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.fechaVenta}">
				<li class="fieldcontain">
					<span id="fechaVenta-label" class="property-label"><g:message code="vehiculo.fechaVenta.label" default="Fecha Venta" /></span>
					
						<span class="property-value" aria-labelledby="fechaVenta-label"><g:formatDate date="${vehiculoInstance?.fechaVenta}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.reparaciones}">
				<li class="fieldcontain">
					<span id="reparaciones-label" class="property-label"><g:message code="vehiculo.reparaciones.label" default="Reparaciones" /></span>
					
						<g:each in="${vehiculoInstance.reparaciones}" var="r">
						<span class="property-value" aria-labelledby="reparaciones-label"><g:link controller="reparacion" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${vehiculoInstance?.vendido}">
				<li class="fieldcontain">
					<span id="vendido-label" class="property-label"><g:message code="vehiculo.vendido.label" default="Vendido" /></span>
					
						<span class="property-value" aria-labelledby="vendido-label"><g:formatBoolean boolean="${vehiculoInstance?.vendido}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${vehiculoInstance?.id}" />
					<g:link class="edit" action="edit" id="${vehiculoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
