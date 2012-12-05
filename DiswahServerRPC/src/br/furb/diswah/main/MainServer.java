package br.furb.diswah.main;

import netbula.ORPC.Pmapsvc;
import netbula.ORPC.Svc;
import netbula.ORPC.rpc_err;
import br.furb.diswah.register.ClientRegisterImpl;
import br.furb.diswah.register.SaleProductRegisterImpl;
import br.furb.diswah.register.SaleRegisterImpl;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class MainServer {

	private static Pmapsvc PORT_MAPPER;
	private static ClientRegisterImpl CLIENT_REGISTER;
	private static SaleRegisterImpl SALE_REGISTER;
	private static SaleProductRegisterImpl SALE_PRODUCT_REGISTER;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		instanciate();
		run();
	}

	private static void instanciate() {
		PORT_MAPPER = new Pmapsvc();

		CLIENT_REGISTER = new ClientRegisterImpl();
		SALE_REGISTER = new SaleRegisterImpl();
		SALE_PRODUCT_REGISTER = new SaleProductRegisterImpl();
	}

	private static void run() {
		run(PORT_MAPPER,"Running server..");
		
		run(CLIENT_REGISTER,"Running client register..");
		run(SALE_REGISTER,"Running sale register..");
		run(SALE_PRODUCT_REGISTER,"Running sale product register..");
	}
	
	private static void run(final Svc svc, final String service){
		new Thread() {
			@Override
			public void run() {
				try {
					System.out.println(service);
					svc.run();
				} catch (rpc_err e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

}