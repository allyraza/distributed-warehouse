package br.furb.diswah.main;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import br.furb.diswah.service.LoginService;
import br.furb.diswah.service.LoginServiceImpl;
import br.furb.diswah.storage.ClassificationStorage;
import br.furb.diswah.storage.ClassificationStorageImpl;
import br.furb.diswah.storage.ProductStorage;
import br.furb.diswah.storage.ProductStorageImpl;
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

	// Services
	private static LoginServiceImpl LOGIN_SERVICE_IMPL;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Server on.");
			
			System.setSecurityManager(null);

			createAndBindStorages();
			createAndBindServices();
			
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
			
			UnicastRemoteObject.unexportObject(USER_STORAGE_IMPL, true);
			UnicastRemoteObject.unexportObject(CLASSIFICATION_STORAGE_IMPL, true);
			UnicastRemoteObject.unexportObject(PRODUCT_STORAGE_IMPL, true);
			
			bindObject(UserStorage.class, UnicastRemoteObject.exportObject(USER_STORAGE_IMPL, 0));
			bindObject(ClassificationStorage.class, UnicastRemoteObject.exportObject(CLASSIFICATION_STORAGE_IMPL, 0));
			bindObject(ProductStorage.class, UnicastRemoteObject.exportObject(PRODUCT_STORAGE_IMPL, 0));
			
		} catch (RemoteException e) {
			System.out.println("Exception: Erro ao carregar storages.\n" + e.getMessage());
		}
	}

	/**
	 * 
	 */
	private static void createAndBindServices() {
		try {
			LOGIN_SERVICE_IMPL = new LoginServiceImpl();
			
			UnicastRemoteObject.unexportObject(LOGIN_SERVICE_IMPL, true);
			
			bindObject(LoginService.class, UnicastRemoteObject.exportObject(LOGIN_SERVICE_IMPL, 0));
			
		} catch (RemoteException e) {
			System.out.println("Exception: Erro ao carregar services.\n" + e.getMessage());
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
			e.printStackTrace();
		}
	}

}