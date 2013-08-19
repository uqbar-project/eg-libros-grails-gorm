<%@ page import="ar.edu.libros.Libro"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="main" />
</head>
<body>
	<g:set var="entityName" value="${message(code: 'libro.label', default: 'Libro')}" />
	<div style="width: 90%; padding: 15pt;">
		<g:render template="titulo" model="['titulo': 'B&uacute;squeda de libros']"/>
		<g:if test="${flash.message}">
			<div class="alert alert-info">
				${flash.message}
			</div>
		</g:if>		
		<div class="accordion" id="accordionPadre">
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordionPadre" href="#collapseOne">
						Par&aacute;metros de b&uacute;squeda </a>
				</div>
				<div id="collapseOne" class="accordion-body collapse in">
					<div class="accordion-inner">
						<form>
							<fieldset>
								<label>T&iacute;tulo</label> 
								<input type="text" name="titulo" id="titulo" class="input" placeholder="Contiene..." value="${libroBusqueda?.titulo}"> 
								<label>Autor:</label> 
								<input type="text" class="input" name="autor" id="autor" placeholder="Contiene..." value="${libroBusqueda?.autor}">
								<br />
								<button type="submit" class="btn btn-primary">
									<g:message code="default.list.label"/>
								</button>
							</fieldset>
						</form>
					</div>
				</div>
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordionPadre" href="#collapseTwo"> Resultados: ${libroInstanceTotal } 
						</a>
					</div>
					<div id="collapseTwo" class="accordion-body collapse in">
						<div class="accordion-inner">
							<div id="list-libro" class="content scaffold-list">
								<table class="table table-striped table-bordered table-hover table-condensed">
									<thead>
										<g:sortableColumn property="autor"
											title="${message(code: 'libro.autor.label', default: 'Autor')}" />
										<g:sortableColumn property="titulo"
											title="${message(code: 'libro.titulo.label', default: 'Titulo')}" />
										<g:sortableColumn property="editorial"
											title="${message(code: 'libro.editorial.label', default: 'Editorial')}" />
										<g:sortableColumn property="anioPublicacion"
											title="${message(code: 'libro.anioPublicacion.label', default: 'A&ntilde;o Publicaci&oacute;n')}" />
									</thead>
									<tbody>
										<g:each in="${libroInstanceList}" status="i"
											var="libroInstance">
											<tr class="${(i % 2) == 0 ? 'info' : ''}">
												<td><g:link action="show" id="${libroInstance.id}">
														${fieldValue(bean: libroInstance, field: "autor")}
													</g:link></td>
												<td>
													${fieldValue(bean: libroInstance, field: "titulo")}
												</td>
												<td>
													${fieldValue(bean: libroInstance, field: "editorial")}
												</td>
												<td>
													${libroInstance.anioPublicacion}
												</td>
											</tr>
										</g:each>
									</tbody>
								</table>
								<div class="pagination">
								    <g:paginate total="${libroInstanceTotal}"/>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordionPadre" href="#collapseThree"> Acciones
						</a>
					</div>
					<div id="collapseThree" class="accordion-body collapse in">
						<div class="accordion-inner">
							<g:link class="btn btn-primary" action="create">
								<g:message code="default.create.label" args="[entityName]" />
							</g:link>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

