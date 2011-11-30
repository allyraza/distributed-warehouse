package br.furb.diswah.test;

import netbula.ORPC.rpc_err;
import br.furb.diswah.connection.PropertiesBundle;
import br.furb.diswah.exception.CommunicationException;
import br.furb.diswah.service.SalesRegisterClient;
import br.furb.diswah.transport.BasicTransport;
import br.furb.diswah.transport.TransportFactory;
import br.furb.diswah.transport.TransportMethod;
import br.furb.diswah.transport.TransportProperties;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class RPCTest {
	
	public static void main(String[] args) throws rpc_err, CommunicationException {
		TransportProperties tp = new TransportProperties();
		tp.setHost(PropertiesBundle.getProperty("server.sales.host"));
		
		BasicTransport bt = TransportFactory.createCommunication(tp, TransportMethod.RPC);
		
		SalesRegisterClient src = bt.requestInterface(SalesRegisterClient.class, new Object[]{});
		src.findSale(1l);
	}

}
