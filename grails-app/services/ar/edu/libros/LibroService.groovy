package ar.edu.libros

import org.springframework.transaction.annotation.Transactional

class LibroService {

	// Cambiar el default para poder configurar qué métodos son transaccionales y cuáles no
	static transactional = false

	@Transactional(readOnly = true)
	def getLibros(params, Libro libro) {
		def queryLibros = Libro.createCriteria().list(params) {
			if (libro.titulo) {
				ilike("titulo", "%" + libro.titulo + "%")
			}
			if (libro.autor) {
				ilike("autor", "%" + libro.autor + "%")
			}
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

	@Transactional
	void actualizarLibro(Libro libro) {
		libro.validar()
		if (libro.hasErrors()) {
			throw new RuntimeException("Error validacion")
		} else {
			libro.save(flush: true)
		}
	}

	@Transactional
	def eliminarLibro(Libro libro) {
		libro.delete(flush: true)
	}

}
