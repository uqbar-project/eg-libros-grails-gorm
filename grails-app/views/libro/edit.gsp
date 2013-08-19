<%@ page import="ar.edu.libros.Libro"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<g:set var="entityName" value="${message(code: 'libro.label', default: 'Libro')}" />
<title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>
	<div class="body" style="width: 90%; padding: 15pt;">
		
		<g:render template="menuSuperior" model="[entityName: entityName]"></g:render>
		
		<g:if test="${alta}">
			<g:set var="titulo" value="default.create.title"/>
		</g:if>
		<g:else>
			<g:set var="titulo" value="default.update.title"/>
		</g:else>
		<g:render template="titulo" model="['tituloKey': titulo, 'entityName':'Libro']"/>
		<g:if test="${flash.message}">
			<div class="message">
				${flash.message}
			</div>
		</g:if>
		<g:hasErrors bean="${libroInstance}">
			<div class="alert alert-error">
				<g:renderErrors bean="${libroInstance}" as="list" />
			</div>
		</g:hasErrors>
		<form class="form-horizontal" action="save" method="post">
			<g:hiddenField name="id" value="${libroInstance?.id}" />
			<g:hiddenField name="version" value="${libroInstance?.version}" />
			<div class="control-group ${hasErrors(bean: libroInstance, field: 'autor', 'error')}">
				<label class="control-label" for="autor"><g:message code="default.author.label"/> </label>
				<div class="controls">
					<input class="input-large" type="text" name="autor" id="autor" placeholder="${message(code:'default.author.label')}"  value="${libroInstance?.autor}" />
				</div>
			</div>
			<div class="control-group ${hasErrors(bean: libroInstance, field: 'titulo', 'error')}">
				<label class="control-label" for="titulo"><g:message code="default.title.label"/> </label>
				<div class="controls">
					<input class="input-xxlarge" type="text" name="titulo" id="titulo" placeholder="${message(code:'default.title.label')}" value="${libroInstance?.titulo}" />
				</div>
			</div>
			<div class="control-group ${hasErrors(bean: libroInstance, field: 'editorial', 'error')}">
				<label class="control-label" for="editorial"><g:message code="default.publisher.label"/> </label>
				<div class="controls">
					<input class="input-large" type="text" name="editorial" id="editorial" placeholder="${message(code:'default.publisher.label')}" value="${libroInstance?.editorial}" />
				</div>
			</div>
			<div class="control-group ${hasErrors(bean: libroInstance, field: 'anioPublicacion', 'error')}">
				<label class="control-label" for="editorial"><g:message code="default.publishYear.label"/> </label>
				<div class="controls">
					<input class="input-medium" type="text" name="anioPublicacion" id="anioPublicacion" placeholder="${message(code:'default.publishYear.label')}" value="${libroInstance?.anioPublicacion}" />
				</div>
			</div>
			<div class="buttons">
				<input type="submit" class="btn btn-primary" value="<g:message code="default.add.label" args="[entityName]" />" />
				<g:link class="btn btn-primary" action="list">
					<g:message code="default.cancel.label" />
				</g:link>
			</div>
		</form>
	</div>
</body>
</html>
