package br.furb.diswah.view;

import br.furb.diswah.model.Product;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ProductsView extends AbstractInternalPanel<Product> {

	/**
	 * 
	 */
	public ProductsView(){
		super();
	}
	
	@Override
	protected void createComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getMessagesProperty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}
	
}