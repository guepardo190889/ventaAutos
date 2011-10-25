<%@ page import="ventasautos.Reparacion" %>



<div class="fieldcontain ${hasErrors(bean: reparacionInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="reparacion.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" required="" value="${reparacionInstance?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reparacionInstance, field: 'costo', 'error')} required">
	<label for="costo">
		<g:message code="reparacion.costo.label" default="Costo" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="costo" required="" value="${fieldValue(bean: reparacionInstance, field: 'costo')}"/>
</div>

