package br.furb.diswah.storage;

import br.furb.diswah.model.Classification;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ClassificationStorageImpl extends AbstractEntityStorage<Classification> implements ClassificationStorage {

	@Override
	public Class<Classification> getEntityClass() {
		return Classification.class;
	}

}