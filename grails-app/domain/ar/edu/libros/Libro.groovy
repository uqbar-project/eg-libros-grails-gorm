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
			this.errors.rejectValue "autor", 'default.blank.message', ['autor'] as Object[], ''
		}
		if (!titulo) {
			this.errors.rejectValue "titulo", 'default.blank.message', ['titulo'] as Object[], ''
		}
		if (!editorial) {
			this.errors.rejectValue "editorial", 'default.blank.message', ['editorial'] as Object[], ''
		}
		if (!anioPublicacion) {
			this.errors.rejectValue "anioPublicacion", 'default.blank.message', ['anioPublicacion'] as Object[], ''
		}
		if (anioPublicacion && anioPublicacion > new Date().getAt(Calendar.YEAR)) {
			this.errors.rejectValue 'anioPublicacion', 'validation.less.currentYear', ['anioPublicacion'] as Object[], '' 
		}
	}
}
