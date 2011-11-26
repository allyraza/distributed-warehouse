package br.furb.diswah.test;

import br.furb.diswah.exception.CommunicationException;
import br.furb.diswah.storage.UserStorage;
import br.furb.diswah.transport.BasicTransport;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class TransportTest {
	
	public static void main(String[] args) throws CommunicationException {
		TransportProperties tp = new TransportProperties();
		tp.setHost("localhost");
		
		
		BasicTransport basTransport = TransportFactory.createCommunication(tp, TransportMethod.RMI);
		
		UserStorage u = basTransport.requestInterface(UserStorage.class, new Object[]{});
		System.out.println(u);
	}

}
