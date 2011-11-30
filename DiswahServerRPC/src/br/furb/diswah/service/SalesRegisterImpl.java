package br.furb.diswah.service;

import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.transport.BasicTransport;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class SalesRegisterImpl extends AbstractSalesRegister {

	@Override
	public String registerSale(String in_arg) {
		TransportProperties prop = new TransportProperties();
		prop.setHost(PropertiesBundle.getProperty("server.persistence.host"));
		
		BasicTransport transport = TransportFactory.createCommunication(prop, TransportMethod.CORBA);
		
		
		System.out.println(transport);
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findSale(Long in_arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Long in_arg) {
		// TODO Auto-generated method stub
		return null;
	}

}