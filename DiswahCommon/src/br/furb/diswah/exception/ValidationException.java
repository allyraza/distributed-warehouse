package br.furb.diswah.exception;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ValidationException extends BaseException {

	private static final long serialVersionUID = 9123806689464021703L;

	/**
	 * @param message
	 */
	public ValidationException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param parent
	 */
	public ValidationException(String message, Throwable parent){
		super(message, parent);
	}
	
}