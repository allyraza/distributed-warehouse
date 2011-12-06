package br.furb.diswah.transport;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.exception.CommunicationException;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class RPCTransport extends BasicTransport {

	protected RPCTransport(TransportProperties properties){
		super(properties);
	}
	
	@Override
	public <T> T requestInterface(Class<T> target, Object[] params) throws CommunicationException {
		try {
			return target.getConstructor(String.class, String.class).newInstance(getProperties().getHost(),
																				 PropertiesBundle.getProperty("server.rpc.protocol"));
		} catch (Exception e) {
			throw new CommunicationException(String.format("Ocorreu um erro ao instanciar a classe '%s'",target.getSimpleName()), e);
		}
	}

}