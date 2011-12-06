package br.furb.diswah.view;

import br.furb.diswah.model.Sale;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class SalesView extends AbstractInternalPanel<Sale> {
	
	/**
	 * 
	 */
	public SalesView() {
		super();
	}
	
	@Override
	protected void createComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getMessagesProperty() {
		return "sale";
	}

	/* (non-Javadoc)
	 * @see br.furb.diswah.view.AbstractInternalPanel#getEntityClass()
	 */
	@Override
	protected Class<Sale> getEntityClass() {
		return Sale.class;
	}
	
}