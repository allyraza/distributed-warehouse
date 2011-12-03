package br.furb.diswah.view;

import java.awt.Dimension;



/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ClientsView extends AbstractInternalPanel{
	
	
	/**
	 * 
	 */
	public ClientsView() {
		super();
	}

	/* (non-Javadoc)
	 * @see br.furb.diswah.view.AbstractInternalFrame#createComponents()
	 */
	@Override
	protected void createComponents() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see br.furb.diswah.view.AbstractInternalFrame#getMessagesProperty()
	 */
	@Override
	protected String getMessagesProperty() {
		return "client";
	}

	/* (non-Javadoc)
	 * @see br.furb.diswah.view.AbstractInternalFrame#getSize()
	 */
	@Override
	public Dimension getSize() {
		return new Dimension(500, 500);
	}

	
	
}