package br.furb.diswah.main;

import netbula.ORPC.rpc_err;
import br.furb.diswah.service.SalesRegisterImpl;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class MainServer {

	private static SalesRegisterImpl SALES_REGISTER;
	
	public static void main(String[] args) {
		instanciate();
		run();
	}

	private static void instanciate() {
		SALES_REGISTER = new SalesRegisterImpl();
	}

	private static void run() {
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