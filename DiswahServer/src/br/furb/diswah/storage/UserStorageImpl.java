package br.furb.diswah.storage;

import java.rmi.RemoteException;

import br.furb.diswah.model.User;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class UserStorageImpl extends AbstractEntityStorage<User> implements UserStorage {

	/**
	 * @throws RemoteException
	 */
	protected UserStorageImpl() throws RemoteException {
		super();
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

}