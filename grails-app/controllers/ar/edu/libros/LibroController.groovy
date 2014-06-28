package ar.edu.libros

import org.springframework.dao.DataIntegrityViolationException

import ar.edu.libros.exceptions.DomainObjectNotFoundException
import ar.edu.libros.exceptions.UpdateException

class LibroController {

	def LibroService

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		params.max = params.max = Math.min(max ?: 10, 100)
		def libroBusqueda = new Libro(params)
		def libros = libroService.getLibros(params, libroBusqueda)
		[libroInstanceList: libros, libroInstanceTotal: params.libroInstanceTotal, libroBusqueda: libroBusqueda ]
	}

	def create() {
		render(view: "edit", model: [libroInstance: new Libro(params), alta: true])
	}

	def save() {
		Libro libroInstance = null
		String defaultMessage = null
		Long id = params.id
		boolean alta = id != null
		int version = params.version
		if (id) {
			libroInstance = libroService.getLibro(id)
			defaultMessage = "default.updated.message"
		} else {
			libroInstance = new Libro()
			defaultMessage = "default.created.message"
		}
		try {
			chequearVersion(version, libroInstance)
			libroInstance.properties = params
			libroService.actualizarLibro(libroInstance)
			flash.message = message(code: defaultMessage, args: [
				message(code: 'libro.label', default: 'Libro'),
				libroInstance.id
			])
			redirect(action: "list")
		} catch (UpdateException e) {
			flash.message = "${message(code: 'default.updated.message', args: [message(code: 'libro.label', default: 'Libro'), libroInstance.id])}"
			redirect(action: "show", id: libroInstance.id)
		} catch (ConcurrentModificationException e) {
			render(view: "edit", model: [libroInstance: libroInstance, alta: alta])
		} catch (RuntimeException e) {
			render(view: "edit", model: [libroInstance: libroInstance, alta: alta])
		}
	}

	def show(Long id) {
		def libroInstance = libroService.getLibro(id)
		if (!libroInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'libro.label', default: 'Libro'), id])
			redirect(action: "list")
		}
		else {
			[libroInstance: libroInstance]
		}
	}

	def edit(Long id) {
		def libroInstance = libroService.getLibro(id)
		if (!libroInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'libro.label', default: 'Libro'),
				id
			])
			redirect(action: "list")
		}
		else {
			[libroInstance: libroInstance]
		}
	}

	def delete(Long id) {
		def libroInstance = Libro.get(id)
		if (!libroInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'libro.label', default: 'Libro'),
				id
			])
			redirect(action: "list")
			return
		}

		try {
			libroInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'libro.label', default: 'Libro'),
				id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'libro.label', default: 'Libro'),
				id
			])
			redirect(action: "show", id: id)
		}
	}

	private def chequearVersion(pVersion, domainObject) {
		if (pVersion) {
			def version = pVersion.toLong()
			if (domainObject.version > version) {
				domainObject.errors.rejectValue("version", "default.optimistic.locking.failure", [
					message(code: 'libro.label', default: 'Libro')] as Object[], "Another user has updated this Libro while you were editing")
				throw new ConcurrentModificationException()
			}
		}
	}
}
