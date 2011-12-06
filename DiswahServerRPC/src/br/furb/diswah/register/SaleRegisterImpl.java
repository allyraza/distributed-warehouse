package br.furb.diswah.register;

import java.rmi.RemoteException;
import java.util.List;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.exception.CommunicationException;
import br.furb.diswah.model.Sale;
import br.furb.diswah.storage.SaleStorage;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class SaleRegisterImpl extends AbstractSaleRegister {

	@Override
	public Sale save(Sale in_arg) {
		try {
			return getStorage().save(in_arg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Sale find(Long in_arg) {
		try {
			return getStorage().find(in_arg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Sale> list() {
		try {
			return getStorage().list();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	private SaleStorage getStorage(){
		try {
			TransportProperties prop = new TransportProperties();
			prop.setHost(PropertiesBundle.getProperty("server.persistence.host"));
			return TransportFactory.createCommunication(prop, TransportMethod.RMI)
								   .requestInterface(SaleStorage.class, new Object[]{});
		} catch (CommunicationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}