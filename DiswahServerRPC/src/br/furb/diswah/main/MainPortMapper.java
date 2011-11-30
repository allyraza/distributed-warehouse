package br.furb.diswah.main;

import netbula.ORPC.Pmapsvc;
import netbula.ORPC.rpc_err;

public class MainPortMapper {

	public static void main(String argv[]) throws rpc_err {
		System.out.println("Servidor Pmapsvc em execução");
		new Pmapsvc().run();
		System.out.println("Servidor Pmapsvc encerrado");
	}

}