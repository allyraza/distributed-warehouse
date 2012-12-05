package br.furb.diswah.storage;

import java.rmi.RemoteException;
import java.util.List;

import br.furb.diswah.model.User;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class UserStorageImpl extends AbstractEntityStorage<User> implements UserStorage {

	/**
	 * @throws RemoteException
	 */
	public UserStorageImpl() throws RemoteException {
		super();
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

	/**
	 * @param login
	 * @param password
	 * @return user
	 */
	public User logUser(String login, String password){
		List<User> users = null;
		try {
			users = list();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for(User u : users){
			if(u.getLogin().equals(login) && u.getPassword().equals(password)){
				return u;
			}
		}
		return null;
	}
	
}