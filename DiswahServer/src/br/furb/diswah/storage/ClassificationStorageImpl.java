package br.furb.diswah.storage;

import java.rmi.RemoteException;

import br.furb.diswah.model.Classification;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ClassificationStorageImpl extends AbstractEntityStorage<Classification> implements ClassificationStorage {

	/**
	 * @throws RemoteException
	 */
	protected ClassificationStorageImpl() throws RemoteException {
		super();
	}

	@Override
	public Class<Classification> getEntityClass() {
		return Classification.class;
	}

}