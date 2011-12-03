package br.furb.diswah.main;

import netbula.ORPC.Pmapsvc;
import netbula.ORPC.rpc_err;
import br.furb.diswah.service.SalesRegisterImpl;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class MainServer {

	private static Pmapsvc PORT_MAPPER;
	private static SalesRegisterImpl SALES_REGISTER;
	
	public static void main(String[] args) {
		instanciate();
		run();
	}

	private static void instanciate() {
		PORT_MAPPER = new Pmapsvc();
		SALES_REGISTER = new SalesRegisterImpl();
	}

	private static void run() {
		new Thread() {
			@Override
			public void run() {
				try {
					PORT_MAPPER.run();
				} catch (rpc_err e) {
					e.printStackTrace();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("Running server.");
					SALES_REGISTER.run();
				} catch (rpc_err e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
}