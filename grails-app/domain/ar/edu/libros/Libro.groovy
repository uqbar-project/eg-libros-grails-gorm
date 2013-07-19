package ar.edu.libros

import java.util.Date

class Libro {

	String autor
	String titulo
	String editorial
	Integer anioPublicacion
	
    static constraints = {
		autor length: 100, blank:false
		titulo length: 100, blank:false
		editorial nullable: true, length: 40
		anioPublicacion min: 1500
    }
	
	public Libro() {
		autor = ""
		titulo = ""
		editorial = ""
	}
	
	public String toString() {
		titulo
	}
	
	def validar() {
		if (!autor) {
			this.errors.rejectValue "autor", "Debe completar el autor"
		}
		if (!titulo) {
			this.errors.rejectValue "titulo", "Debe completar el título"
		}
		if (!editorial) {
			this.errors.rejectValue "editorial", "Debe completar la editorial"
		}
		if (!anioPublicacion) {
			this.errors.rejectValue "anioPublicacion", "Debe completar el año de publicación"
		}
		if (anioPublicacion && anioPublicacion > new Date().getAt(Calendar.YEAR)) {
			this.errors.rejectValue "anioPublicacion", "El año de publicación no puede ser posterior al año actual" 
		}
	}
}
