package br.furb.diswah.exception;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class CommunicationException extends BaseException {

	private static final long serialVersionUID = 9123806689464021703L;

	/**
	 * @param message
	 */
	public CommunicationException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param parent
	 */
	public CommunicationException(String message, Throwable parent){
		super(message, parent);
	}
	
}