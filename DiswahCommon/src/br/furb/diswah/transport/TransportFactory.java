package br.furb.diswah.transport;

import br.furb.diswah.transport.corba.CorbaTransport;
import br.furb.diswah.transport.rmi.RMITransport;
import br.furb.diswah.transport.rpc.RPCTransport;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class TransportFactory {
	
	static{
		System.setSecurityManager(null);
	}

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