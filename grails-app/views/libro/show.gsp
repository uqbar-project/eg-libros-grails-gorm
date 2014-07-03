<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<title>Ver libro</title>
</head>
<body>
	<div class="body" style="width: 90%; padding: 15pt;">
		<g:render template="menuSuperior"></g:render>
		<g:render template="titulo" model="['titulo': 'Ver libro']"/>
		<g:if test="${flash.message}">
			<div class="message">
				${flash.message}
			</div>
		</g:if>
		<g:form class="form-horizontal" method="post">
			<div class="control-group">
				<label class="control-label" for="autor">Autor&nbsp;&nbsp; </label> <span class="input-xlarge uneditable-input"> ${libroInstance?.autor} </span>
			</div>
			<div class="control-group">
				<label class="control-label" for="titulo">T&iacute;tulo&nbsp;&nbsp; </label> <span class="input-xxlarge uneditable-input"> ${libroInstance?.titulo} </span>
			</div>
			<div class="control-group">
				<label class="control-label" for="editorial">Editorial&nbsp;&nbsp; </label> <span class="input-xlarge uneditable-input"> ${libroInstance?.editorial} </span>
			</div>
			<div class="control-group">
				<label class="control-label" for="editorial">A&ntilde;o de Publicaci&oacute;n&nbsp;&nbsp; </label> <span class="input-large uneditable-input"> ${libroInstance?.anioPublicacion} </span>
			</div>
			<div class="buttons">
				<g:hiddenField name="id" value="${libroInstance?.id}" />
				<g:actionSubmit class="btn btn-primary" action="edit" value="Editar libro"/>
				<!--  se pueden poner botones con íconos como éste
				<button class="btn btn-primary" name="_action_edit" value="Editar">
					<i class="icon-file icon-white"></i>Editar
				</button>
				 -->
				<g:actionSubmit class="btn btn-primary" action="delete" value="Eliminar Libro"/>
				<g:link class="btn btn-primary" action="list">
					Cancelar
				</g:link>
			</div>
		</g:form>
	</div>
</body>
</html>
