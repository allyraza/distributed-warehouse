package br.furb.diswah.test;

import java.rmi.RemoteException;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.exception.CommunicationException;
import br.furb.diswah.model.User;
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
	
	/**
	 * @param args
	 * @throws CommunicationException
	 * @throws RemoteException
	 */
	public static void main(String[] args) throws CommunicationException, RemoteException {
		
		TransportProperties tp = new TransportProperties();
		tp.setHost(PropertiesBundle.getProperty("server.persistence.host"));
		
		BasicTransport basTransport = TransportFactory.createCommunication(tp, TransportMethod.RMI);
		
		UserStorage u = (UserStorage) basTransport.requestInterface(UserStorage.class, new Object[]{});
		
		System.out.println(u);
		
		u.save(new User());
	}

}