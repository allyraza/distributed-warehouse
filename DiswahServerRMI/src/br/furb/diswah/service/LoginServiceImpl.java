package br.furb.diswah.service;

import java.rmi.RemoteException;

import br.furb.diswah.model.User;
import br.furb.diswah.resource.MessageBundle;
import br.furb.diswah.storage.UserStorageImpl;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class LoginServiceImpl extends BaseService implements LoginService {

	/**
	 * @throws RemoteException
	 */
	public LoginServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public User login(String login, String password) throws RemoteException {
		User user = new UserStorageImpl().logUser(login, password);

		if(user == null)
			throw new RemoteException(MessageBundle.getMessage("service.login.error.notfound"));
		
		return user;
	}

}