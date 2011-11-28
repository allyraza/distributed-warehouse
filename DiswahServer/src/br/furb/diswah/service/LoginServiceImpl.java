package br.furb.diswah.service;

import java.rmi.RemoteException;

import br.furb.diswah.exception.BusinessException;
import br.furb.diswah.model.User;

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
	public User login(String login, String password) throws BusinessException {
		// TODO Auto-generated method stub
		throw new BusinessException("Not implemented yet.");
	}

}