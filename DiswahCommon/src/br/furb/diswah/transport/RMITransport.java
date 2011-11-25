package br.furb.diswah.transport;

import java.rmi.Naming;

import br.furb.diswah.exception.CommunicationException;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class RMITransport extends BasicTransport {

	protected RMITransport(TransportProperties properties){
		super(properties);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> T requestInterface(Class<T> target, Object[] params) throws CommunicationException{
		try {
			return (T) Naming.lookup(getLookupName(target));
		} catch (Exception e) {
			throw new CommunicationException(String.format("Não foi possível encontrar a interface '%s'", target.getName()), e);
		}
		
	}

	/**
	 * @return
	 */
	private <T> String getLookupName(Class<T> target) {
		return String.format("//%s/s",getProperties().getHost(), target.getName());
	}

}