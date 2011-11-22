package br.furb.diswah.storage;

import java.util.List;

import br.furb.diswah.exception.ValidationException;
import br.furb.diswah.model.BasicEntity;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public abstract class AbstractEntityStorage<T extends BasicEntity> implements EntityStorage<T>{

	@Override
	public void validate(T value) throws ValidationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T save(T value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> saveAll(List<T> values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> list() {
		// TODO Auto-generated method stub
		return null;
	}

}