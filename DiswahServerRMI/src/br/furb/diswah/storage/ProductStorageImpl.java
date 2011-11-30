package br.furb.diswah.storage;

import java.rmi.RemoteException;

import br.furb.diswah.model.Product;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ProductStorageImpl extends AbstractEntityStorage<Product> implements ProductStorage {

	/**
	 * @throws RemoteException
	 */
	public ProductStorageImpl() throws RemoteException {
		super();
	}

	@Override
	public Class<Product> getEntityClass() {
		return Product.class;
	}
	
	/* (non-Javadoc)
	 * @see br.furb.diswah.storage.AbstractEntityStorage#beforeSave(br.furb.diswah.model.BasicEntity)
	 */
	@Override
	protected void beforeSave(Product value) {
		if(value.getClassification() != null && (value.getClassification().getId() == null || 
												 value.getClassification().getId() == 0)){
			try {
				new ClassificationStorageImpl().save(value.getClassification());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
}