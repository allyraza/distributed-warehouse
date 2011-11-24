package br.furb.diswah.storage;

import br.furb.diswah.model.User;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class UserStorageImpl extends AbstractEntityStorage<User> implements UserStorage {

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

}