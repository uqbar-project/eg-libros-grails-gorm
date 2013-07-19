package ar.edu.libros.exceptions

class UpdateException extends RuntimeException {

	/***
	 * Representa un error al actualizar un objeto de dominio
	 */
	
	public UpdateException(String msg) {
		super(msg)
	}
	
	public UpdateException(String msg, Throwable e) {
		super(msg, e)
	}
	
}
