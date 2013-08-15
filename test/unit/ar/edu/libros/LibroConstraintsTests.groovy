package ar.edu.libros

import static org.junit.Assert.*

import ar.edu.libros.Libro
import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(Libro)
class LibroConstraintsTests {

	def unLibro
	
    void setUp() {
		unLibro = new Libro()
		mockForConstraintsTests(Libro)
    }

	@Test
    void "anioPublicacion no puede ser menor a 1500"() {
        unLibro.anioPublicacion = 1499
		
		assert !unLibro.validate()
		assert "min" == unLibro.errors["anioPublicacion"]
    }

	@Test
	void "autor no puede estar vacio"() {
		unLibro.autor = ""
		
		assert !unLibro.validate()
		assert "blank" == unLibro.errors["autor"]
	}
}
