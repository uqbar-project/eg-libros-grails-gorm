import ar.edu.libros.Libro

class BootStrap {

    def init = { servletContext ->
		
		if (Libro.count() == 0) {
			println "Generamos juego de datos de libros"
			// Genero el juego de datos
			new Libro(autor: "Julio Cortázar", titulo: "Rayuela", editorial: "Alfaguara", anioPublicacion: 1965).save(failOnError: true)
			new Libro(autor: "Julio Cortázar", titulo: "Octaedro", editorial: "Alfaguara", anioPublicacion: 1968).save(failOnError: true)
			new Libro(autor: "José Saramago", titulo: "Ensayo sobre la ceguera", editorial: "Sudamericana", anioPublicacion: 1998).save(failOnError: true)
			new Libro(autor: "Jorge Asís", titulo: "Flores robadas en los jardines de Quilmes", editorial: "Planeta", anioPublicacion: 1981).save(failOnError: true)
			new Libro(autor: "Osvaldo Bayer", titulo: "La Patagonia Rebelde", editorial: "Galerna", anioPublicacion: 1972).save(failOnError: true)
			new Libro(autor: "Fyodor Dostoyevsky", titulo: "Crimen y castigo", editorial: "Galerna", anioPublicacion: 1866).save(failOnError: true)
		}
		
    }
    def destroy = {
    }
}
