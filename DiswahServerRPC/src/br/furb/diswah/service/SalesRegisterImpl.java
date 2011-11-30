package br.furb.diswah.service;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.exception.CommunicationException;
import br.furb.diswah.model.Sale;
import br.furb.diswah.storage.SaleStorage;
import br.furb.diswah.transport.BasicTransport;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;
import br.furb.diswah.util.Utils;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class SalesRegisterImpl extends AbstractSalesRegister {

	private SaleStorage saleStorage;
	
	@Override
	public String registerSale(String saleStr) {
		try {
			Sale sale = Utils.deserializeObject(Sale.class, saleStr);
			
			getSaleStorage().save(sale);

			return Utils.serializeObject(sale);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String findSale(Long id) {
		try {
			return Utils.serializeObject(getSaleStorage().find(id));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String list() {
		try {
			return Utils.serializeObject(getSaleStorage().list());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String delete(Long id) {
		try {
			return Utils.serializeObject(getSaleStorage().delete(getSaleStorage().find(id)));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private SaleStorage getSaleStorage() throws CommunicationException{
		if(saleStorage == null){
			TransportProperties prop = new TransportProperties();
			prop.setHost(PropertiesBundle.getProperty("server.persistence.host"));
			
			BasicTransport transport = TransportFactory.createCommunication(prop, TransportMethod.CORBA);
		
			saleStorage = transport.requestInterface(SaleStorage.class, new Object[]{});
		}
		
		return saleStorage;
	}

}