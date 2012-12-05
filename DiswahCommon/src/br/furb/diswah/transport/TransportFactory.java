package br.furb.diswah.transport;


/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class TransportFactory {
	
	static{
		System.setSecurityManager(null);
	}

	/**
	 * @param properties
	 * @param method
	 * @return the transport
	 */
	public static BasicTransport createCommunication(TransportProperties properties, TransportMethod method) {
		switch (method) {
			case CORBA:
				return new CorbaTransport(properties);
			case RMI:
				return new RMITransport(properties);
			case RPC:
				return new RPCTransport(properties);
		}
		return null;
	}

}