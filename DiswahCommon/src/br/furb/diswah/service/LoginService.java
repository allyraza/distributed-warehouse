package br.furb.diswah.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.furb.diswah.model.User;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public interface LoginService extends Remote{

	User login(String login, String password) throws RemoteException;
	
}