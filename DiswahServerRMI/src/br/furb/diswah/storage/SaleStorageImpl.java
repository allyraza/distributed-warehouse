package br.furb.diswah.storage;

import java.rmi.RemoteException;

import br.furb.diswah.model.Sale;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class SaleStorageImpl extends AbstractEntityStorage<Sale> implements SaleStorage {

	/**
	 * @throws RemoteException
	 */
	public SaleStorageImpl() throws RemoteException {
		super();
	}

	@Override
	protected Class<Sale> getEntityClass() {
		return Sale.class;
	}

}