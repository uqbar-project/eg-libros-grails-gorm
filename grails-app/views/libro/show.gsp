<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<title>Ver libro</title>
</head>
<body>
	<div class="body" style="width: 90%; padding: 15pt;">
		<g:render template="menuSuperior"/>
		<g:render template="titulo" model="['titulo': 'Ver libro']"/>
		<g:if test="${flash.message}">
			<div class="message">
				${flash.message}
			</div>
		</g:if>
		<g:form class="form-horizontal" method="post">
			<div class="row">
				<div class="col-md-6">
					<label class="control-label" for="autor">Autor&nbsp;&nbsp; </label> 
					<input class="readonly form-control" type="text" value="${libroInstance?.autor}" disabled="disabled"/>
				</div>
				<div class="col-md-6">
					<label class="control-label" for="titulo">T&iacute;tulo&nbsp;&nbsp; </label>
					<input class="readonly form-control" type="text" value="${libroInstance?.titulo}" disabled="disabled"/>
				</div>
				<div class="col-md-6">	
					<label class="control-label" for="editorial">Editorial&nbsp;&nbsp; </label> 
					<input class="readonly form-control" type="text" value="${libroInstance?.editorial}" disabled="disabled"/>
				</div>
				<div class="col-md-6">
					<label class="control-label" for="editorial">A&ntilde;o de Publicaci&oacute;n&nbsp;&nbsp; </label>
					<input class="readonly form-control" type="text" value="${libroInstance?.anioPublicacion}" disabled="disabled"/> 
				</div>
			</div>
			<div class="buttons">
				<br>
				<g:hiddenField name="id" value="${libroInstance?.id}" />
				<g:actionSubmit class="btn btn-primary" action="edit" value="Editar"/>
				<!--  se pueden poner botones con íconos como éste
				<button class="btn btn-primary" name="_action_edit" value="Editar">
					<i class="icon-file icon-white"></i>Editar
				</button>
				 -->
				<g:actionSubmit class="btn btn-primary" action="delete" value="Eliminar"/>
				<g:link class="btn btn-primary" action="list">
					Cancelar
				</g:link>
			</div>
		</g:form>
	</div>
</body>
</html>
