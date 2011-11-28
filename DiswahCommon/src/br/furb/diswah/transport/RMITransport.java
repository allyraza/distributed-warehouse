package br.furb.diswah.transport;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

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
			Registry registry = LocateRegistry.getRegistry(getProperties().getHost());
			return (T) registry.lookup(target.getSimpleName());
		} catch (Exception e) {
			throw new CommunicationException(String.format("Não foi possível encontrar a interface '%s'",  target.getName()), e);
		}
		
	}

}