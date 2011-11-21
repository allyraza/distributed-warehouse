package br.furb.diswah.service;

import br.furb.diswah.exception.BusinessException;
import br.furb.diswah.model.User;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public interface LoginService {

	User login(String login, String password) throws BusinessException;
	
}