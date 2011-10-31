<%@ page import="ventasautos.Vehiculo" %>

<!--<g:hiddenField name="fechaAlta" />
<g:hiddenField name="fechaVenta" />
<g:hiddenField name="vendido" />-->

<div class="fieldcontain ${hasErrors(bean: vehiculoInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="vehiculo.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" required="" value="${vehiculoInstance?.descripcion}"/>
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