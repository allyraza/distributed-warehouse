package br.furb.diswah.main;

import netbula.ORPC.Pmapsvc;
import netbula.ORPC.rpc_err;
import br.furb.diswah.service.SalesRegisterImpl;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class MainServer {

	private static Pmapsvc PORTMAPPER_SERVICE;
	private static SalesRegisterImpl SALES_REGISTER;
	
	public static void main(String[] args) {
		instanciate();
		System.out.println("Instanciated.");
		run();
		System.out.println("Running.");
	}

	/**
	 * 
	 */
	private static void instanciate() {
		PORTMAPPER_SERVICE = new Pmapsvc();
		SALES_REGISTER = new SalesRegisterImpl();
	}

	/**
	 * 
	 */
	private static void run() {
		new Thread() {
			@Override
			public void run() {
				try {
					PORTMAPPER_SERVICE.run();
				} catch (rpc_err e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				try {
					SALES_REGISTER.run();
				} catch (rpc_err e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
}