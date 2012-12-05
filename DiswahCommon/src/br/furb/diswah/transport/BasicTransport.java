package br.furb.diswah.transport;

import br.furb.diswah.exception.CommunicationException;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public abstract class BasicTransport {
	
	private TransportProperties properties;
	
	protected BasicTransport(TransportProperties properties){
		this.properties = properties;
	}
	
	/**
	 * @return properties
	 */
	public TransportProperties getProperties() {
		return properties;
	}

	/**
	 * @param target
	 * @param params
	 * @return instance
	 * @throws CommunicationException
	 */
	public abstract <T> T requestInterface(Class<T> target, Object[] params) throws CommunicationException;
	
}