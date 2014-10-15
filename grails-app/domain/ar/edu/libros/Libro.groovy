package ar.edu.libros

import java.util.Date

class Libro {

	static int MINIMO_ANIO_PUBLICACION = 1500
	
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
			this.errors.reject 'autor', 'Debe ingresar autor'
		}
		if (!titulo) {
			this.errors.reject 'titulo', 'Debe ingresar título'
		}
		if (!editorial) {
			this.errors.reject 'editorial', 'Debe ingresar editorial'
		}
		if (!anioPublicacion) {
			this.errors.reject 'anioPublicacion', 'Debe ingresar año de publicación'
		}
		if (anioPublicacion && anioPublicacion < MINIMO_ANIO_PUBLICACION) {
			this.errors.reject 'anioPublicacion', 'El año de publicación debe ser superior a ' + MINIMO_ANIO_PUBLICACION
		}
		if (anioPublicacion && anioPublicacion > new Date().getAt(Calendar.YEAR)) {
			this.errors.reject 'anioPublicacion', 'El año de publicación no puede ser superior al año actual' 
		}
	}
}
