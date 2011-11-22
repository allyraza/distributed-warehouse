package br.furb.diswah.storage;

import java.util.List;

import br.furb.diswah.exception.ValidationException;
import br.furb.diswah.model.BasicEntity;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public interface EntityStorage<T extends BasicEntity> {

	void validate(T value) throws ValidationException;
	
	T find(Long id);
	
	T save(T value);
	
	List<T> saveAll(List<T> values);

	List<T> list();
	
}