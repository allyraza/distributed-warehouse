package br.furb.diswah.register;

import java.rmi.RemoteException;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.exception.CommunicationException;
import br.furb.diswah.model.Product;
import br.furb.diswah.storage.ProductStorage;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;
import br.furb.diswah.util.Utils;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ProductRegisterImpl extends ProductRegisterPOA {
	
	@Override
	public String save(String p1) {
		try {
			Product product = Utils.deserializeObject(Product.class, p1);
			return Utils.serializeObject(getStorage().save(product));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String find(int p1) {
		try {
			Long id = Long.valueOf(String.valueOf(p1));
			return Utils.serializeObject(getStorage().find(id));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;	
	}

	@Override
	public String list() {
		try {
			return Utils.serializeObject(getStorage().list());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private ProductStorage getStorage(){
		try {
			TransportProperties prop = new TransportProperties();
			prop.setHost(PropertiesBundle.getProperty("server.persistence.host"));
			return TransportFactory.createCommunication(prop, TransportMethod.RMI)
								   .requestInterface(ProductStorage.class, new Object[]{});
		} catch (CommunicationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}