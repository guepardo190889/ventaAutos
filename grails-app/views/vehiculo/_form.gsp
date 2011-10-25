<%@ page import="ventasautos.Vehiculo" %>



<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'costo', 'error')} required">
	<label for="costo">
		<g:message code="vehiculo.costo.label" default="Costo" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="costo" required="" value="${fieldValue(bean: vehiculoInstance, field: 'costo')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'costoVenta', 'error')} required">
	<label for="costoVenta">
		<g:message code="vehiculo.costoVenta.label" default="Costo Venta" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="costoVenta" required="" value="${fieldValue(bean: vehiculoInstance, field: 'costoVenta')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'fechaVenta', 'error')} required">
	<label for="fechaVenta">
		<g:message code="vehiculo.fechaVenta.label" default="Fecha Venta" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaVenta" precision="day"  value="${vehiculoInstance?.fechaVenta}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'reparaciones', 'error')} ">
	<label for="reparaciones">
		<g:message code="vehiculo.reparaciones.label" default="Reparaciones" />
		
	</label>
	<g:select name="reparaciones" from="${ventasautos.Reparacion.list()}" multiple="multiple" optionKey="id" size="5" value="${vehiculoInstance?.reparaciones*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'vendido', 'error')} ">
	<label for="vendido">
		<g:message code="vehiculo.vendido.label" default="Vendido" />
		
	</label>
	<g:checkBox name="vendido" value="${vehiculoInstance?.vendido}" />
</div>

