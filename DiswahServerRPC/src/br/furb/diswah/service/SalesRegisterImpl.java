package br.furb.diswah.service;

import java.util.List;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.exception.CommunicationException;
import br.furb.diswah.model.Sale;
import br.furb.diswah.storage.SaleStorage;
import br.furb.diswah.transport.BasicTransport;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class SalesRegisterImpl extends AbstractSalesRegister {

	private SaleStorage saleStorage;
	
	@Override
	public Sale registerSale(Sale sale) {
		try {
			return getSaleStorage().save(sale);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Sale findSale(Long id) {
		try {
			return getSaleStorage().find(id);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Sale> list() {
		try {
			return getSaleStorage().list();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Sale delete(Long id) {
		try {
			return getSaleStorage().delete(getSaleStorage().find(id));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private SaleStorage getSaleStorage() throws CommunicationException{
		if(saleStorage == null){
			TransportProperties prop = new TransportProperties();
			prop.setHost(PropertiesBundle.getProperty("server.rmi.host"));
			
			BasicTransport transport = TransportFactory.createCommunication(prop, TransportMethod.RMI);
		
			saleStorage = transport.requestInterface(SaleStorage.class, new Object[]{});
		}
		
		return saleStorage;
	}

}