package br.furb.diswah.main;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import br.furb.diswah.storage.ClassificationStorage;
import br.furb.diswah.storage.ClassificationStorageImpl;
import br.furb.diswah.storage.ClientStorage;
import br.furb.diswah.storage.ClientStorageImpl;
import br.furb.diswah.storage.ProductStorage;
import br.furb.diswah.storage.ProductStorageImpl;
import br.furb.diswah.storage.SaleProductStorage;
import br.furb.diswah.storage.SaleProductStorageImpl;
import br.furb.diswah.storage.SaleStorage;
import br.furb.diswah.storage.SaleStorageImpl;
import br.furb.diswah.storage.UserStorage;
import br.furb.diswah.storage.UserStorageImpl;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class MainServer {
	
	// Storages
	private static UserStorageImpl USER_STORAGE_IMPL;
	private static ClassificationStorageImpl CLASSIFICATION_STORAGE_IMPL;
	private static ProductStorageImpl PRODUCT_STORAGE_IMPL;
	private static ClientStorageImpl CLIENT_STORAGE_IMPL;
	private static SaleStorageImpl SALE_STORAGE_IMPL;
	private static SaleProductStorageImpl SALE_PRODUCT_STORAGE_IMPL;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Server on.");
			
			System.setSecurityManager(null);

			createAndBindStorages();
			
			System.out.println("Bindings up.");
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}

	/**
	 * 
	 */
	private static void createAndBindStorages() {
		try {
			USER_STORAGE_IMPL = new UserStorageImpl();
			CLASSIFICATION_STORAGE_IMPL = new ClassificationStorageImpl();
			PRODUCT_STORAGE_IMPL = new ProductStorageImpl();
			CLIENT_STORAGE_IMPL = new ClientStorageImpl();
			SALE_STORAGE_IMPL = new SaleStorageImpl();
			SALE_PRODUCT_STORAGE_IMPL = new SaleProductStorageImpl();
			
			UnicastRemoteObject.unexportObject(USER_STORAGE_IMPL, true);
			UnicastRemoteObject.unexportObject(CLASSIFICATION_STORAGE_IMPL, true);
			UnicastRemoteObject.unexportObject(PRODUCT_STORAGE_IMPL, true);
			UnicastRemoteObject.unexportObject(CLIENT_STORAGE_IMPL, true);
			UnicastRemoteObject.unexportObject(SALE_STORAGE_IMPL, true);
			UnicastRemoteObject.unexportObject(SALE_PRODUCT_STORAGE_IMPL, true);
			
			bindObject(UserStorage.class, UnicastRemoteObject.exportObject(USER_STORAGE_IMPL, 0));
			bindObject(ClassificationStorage.class, UnicastRemoteObject.exportObject(CLASSIFICATION_STORAGE_IMPL, 0));
			bindObject(ProductStorage.class, UnicastRemoteObject.exportObject(PRODUCT_STORAGE_IMPL, 0));
			bindObject(ClientStorage.class, UnicastRemoteObject.exportObject(CLIENT_STORAGE_IMPL, 0));
			bindObject(SaleStorage.class, UnicastRemoteObject.exportObject(SALE_STORAGE_IMPL, 0));
			bindObject(SaleProductStorage.class, UnicastRemoteObject.exportObject(SALE_PRODUCT_STORAGE_IMPL, 0));
			
		} catch (RemoteException e) {
			System.out.println("Exception: Erro ao carregar storages.\n" + e.getMessage());
		}
	}

	/**
	 * @param clazz
	 * @param remoteObject
	 */
	private static void bindObject(Class<?> clazz, Remote remoteObject) {
		try {
			LocateRegistry.getRegistry().rebind(clazz.getSimpleName(),  remoteObject);
		} catch (Exception e) {
			System.err.println("Erro ao efetuar bind: " + clazz.getName());
			e.printStackTrace();
		}
	}

}