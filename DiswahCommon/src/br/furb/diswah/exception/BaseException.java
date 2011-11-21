package br.furb.diswah.exception;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class BaseException extends Throwable {

	private static final long serialVersionUID = 111667835166749481L;
	
	protected BaseException(String message){
		this(message, null);
	}
	
	protected BaseException(String message, Throwable parent){
		super(message, parent);
	}

}