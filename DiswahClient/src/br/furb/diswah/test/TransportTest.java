package br.furb.diswah.test;

import br.furb.diswah.exception.CommunicationException;
import br.furb.diswah.storage.UserStorage;
import br.furb.diswah.transport.BasicTransport;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class TransportTest {
	
	public static void main(String[] args) throws CommunicationException {
		BasicTransport basTransport = TransportFactory.createCommunication(null, TransportMethod.RMI);
		
		UserStorage u = basTransport.requestInterface(UserStorage.class, new Object[]{});
		System.out.println(";D");
	}

}
