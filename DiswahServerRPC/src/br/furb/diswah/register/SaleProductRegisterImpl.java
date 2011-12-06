package br.furb.diswah.register;

import java.rmi.RemoteException;
import java.util.List;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.exception.CommunicationException;
import br.furb.diswah.model.SaleProduct;
import br.furb.diswah.storage.SaleProductStorage;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class SaleProductRegisterImpl extends AbstractSaleProductRegister {

	@Override
	public SaleProduct save(SaleProduct in_arg) {
		try {
			return getStorage().save(in_arg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SaleProduct find(Long in_arg) {
		try {
			return getStorage().find(in_arg);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SaleProduct> list() {
		try {
			return getStorage().list();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	private SaleProductStorage getStorage(){
		try {
			TransportProperties prop = new TransportProperties();
			prop.setHost(PropertiesBundle.getProperty("server.persistence.host"));
			return TransportFactory.createCommunication(prop, TransportMethod.RMI)
								   .requestInterface(SaleProductStorage.class, new Object[]{});
		} catch (CommunicationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}