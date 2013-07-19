package ar.edu.libros.exceptions

class DomainObjectNotFoundException extends RuntimeException {

	/***
	 * Representa un error al buscar un objeto de dominio existente 
	 */
	
	public DomainObjectNotFoundException(String msg) {
		super(msg)
	}
	
	public DomainObjectNotFoundException(String msg, Throwable e) {
		super(msg, e)
	}
	
}
