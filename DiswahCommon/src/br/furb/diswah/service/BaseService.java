package br.furb.diswah.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public abstract class BaseService extends UnicastRemoteObject{

	/**
	 * @throws RemoteException
	 */
	protected BaseService() throws RemoteException {
		super();
	}

}