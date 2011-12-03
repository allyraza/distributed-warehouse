package br.furb.diswah.test;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.exception.CommunicationException;
import br.furb.diswah.storage.corba.EntityStorage;
import br.furb.diswah.storage.corba.EntityStorageHelper;
import br.furb.diswah.transport.BasicTransport;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class CorbaTest {
	
	public static void main(String[] args) throws CommunicationException {
		TransportProperties properties = new TransportProperties();
		properties.setHost(PropertiesBundle.getProperty("server.persistence.host"));
		BasicTransport bt = TransportFactory.createCommunication(properties, TransportMethod.CORBA);
		
		bt.requestInterface(EntityStorage.class, new Object[]{EntityStorageHelper.class});
	}

}
