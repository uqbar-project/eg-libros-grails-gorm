package ar.edu.libros

import org.springframework.transaction.annotation.Transactional

class LibroService {

	// Cambiar el default para poder configurar qué métodos son transaccionales y cuáles no
	static transactional = false

	@Transactional(readOnly = true)
	def getLibros(params, Libro libro) {
		def queryLibros = Libro.createCriteria().list(params) {
			ilike("titulo", "%" + libro.titulo + "%")
			ilike("autor", "%" + libro.autor + "%")
		}
		// Seteamos el totalCount para paginar los resultados en la grilla
		params.libroInstanceTotal = queryLibros.totalCount
		// y devolvemos el resultado del query
		queryLibros
	}

	@Transactional(readOnly = true)
	def getLibro(idLibro) {
		Libro.get(idLibro)
	}

	@Transactional(readOnly = true)
	boolean actualizarLibro(Libro libro) {
		if (libro.hasErrors()) {
			false
		} else {
			return this.guardar(libro)
		}
	}

	// Este método está aislando la transacción
	// para evitar hacer un entidad.discard() en cada guardar()
	@Transactional
	boolean guardar(entidad) {
		entidad.save(flush: true)
	}

	@Transactional
	def eliminarLibro(Libro libro) {
		libro.delete(flush: true)
	}

}
