package br.furb.diswah.storage;

import java.rmi.RemoteException;

import br.furb.diswah.model.Client;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ClientStorageImpl extends AbstractEntityStorage<Client> implements ClientStorage {

	/**
	 * @throws RemoteException
	 */
	public ClientStorageImpl() throws RemoteException {
		super();
	}

	@Override
	protected Class<Client> getEntityClass() {
		return Client.class;
	}
	
}