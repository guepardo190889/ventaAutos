<%@ page import="ventasautos.Vehiculo" %>


<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'modelo', 'error')} required">
	<label for="modelo">
		<g:message code="vehiculo.modelo.label" default="Modelo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="modelo" required="" value="${vehiculoInstance?.modelo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'marca', 'error')} required">
	<label for="marca">
		<g:message code="vehiculo.marca.label" default="Marca" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="marca" required="" value="${vehiculoInstance?.marca}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'costo', 'error')} required">
	<label for="costo">
		<g:message code="vehiculo.costo.label" default="Costo" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="costo" min="1.00" max="999999.00" required="" value="${fieldValue(bean: vehiculoInstance, field: 'costo')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'costoVenta', 'error')} required">
	<label for="costoVenta">
		<g:message code="vehiculo.costoVenta.label" default="Costo Venta" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="costoVenta" min="1.00" max="999999.00" required="" value="${fieldValue(bean: vehiculoInstance, field: 'costoVenta')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="vehiculo.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="descripcion" required="" value="${vehiculoInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'reparaciones', 'error')} ">
	<label for="reparaciones">
		<g:message code="vehiculo.reparaciones.label" default="Reparaciones" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${vehiculoInstance?.reparaciones?}" var="r">
    <li><g:link controller="reparacion" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="reparacion" action="create" params="['vehiculo.id': vehiculoInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'reparacion.label', default: 'Reparacion')])}</g:link>
</li>
</ul>

</div>
