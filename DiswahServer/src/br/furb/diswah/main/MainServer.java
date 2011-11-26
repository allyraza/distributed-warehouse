package br.furb.diswah.main;

import java.rmi.Naming;

import br.furb.diswah.storage.UserStorage;
import br.furb.diswah.storage.UserStorageImpl;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class MainServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UserStorageImpl u = new UserStorageImpl();
			Naming.rebind("//localhost/"+UserStorage.class.getName(), u);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}

}
