package br.furb.diswah.storage;

import java.rmi.RemoteException;

import br.furb.diswah.model.SaleProduct;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class SaleProductStorageImpl extends AbstractEntityStorage<SaleProduct> implements SaleProductStorage {

	/**
	 * @throws RemoteException
	 */
	public SaleProductStorageImpl() throws RemoteException {
		super();
	}

	@Override
	protected Class<SaleProduct> getEntityClass() {
		return SaleProduct.class;
	}

}