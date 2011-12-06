package br.furb.diswah.register;

import java.rmi.RemoteException;
import java.util.List;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.exception.CommunicationException;
import br.furb.diswah.model.Client;
import br.furb.diswah.storage.ClientStorage;
import br.furb.diswah.storage.UserStorage;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ClientRegisterImpl extends AbstractClientRegister {

	@Override
	public Client save(Client in_arg) {
		try {
			return getStorage().save(in_arg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client find(Long in_arg) {
		try {
			return getStorage().find(in_arg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Client> list() {
		try {
			return getStorage().list();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ClientStorage getStorage(){
		try {
			TransportProperties prop = new TransportProperties();
			prop.setHost(PropertiesBundle.getProperty("server.persistence.host"));
			return TransportFactory.createCommunication(prop, TransportMethod.RMI)
								   .requestInterface(ClientStorage.class, new Object[]{});
		} catch (CommunicationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}