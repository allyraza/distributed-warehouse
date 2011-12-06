package br.furb.diswah.view;

import br.furb.diswah.model.SaleProduct;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class SalesProductsView extends AbstractInternalPanel<SaleProduct> {

	/**
	 * 
	 */
	public SalesProductsView() {
		super();
	}
	
	@Override
	protected void createComponents() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getMessagesProperty() {
		return "saleproduct";
	}

	@Override
	protected Class<SaleProduct> getEntityClass() {
		return SaleProduct.class;
	}

}