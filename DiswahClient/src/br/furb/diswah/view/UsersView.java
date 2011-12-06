package br.furb.diswah.view;

import br.furb.diswah.model.User;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class UsersView extends AbstractInternalPanel<User>  {

	/**
	 * 
	 */
	public UsersView() {
		super();
	}
	
	@Override
	protected void createComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getMessagesProperty() {
		return "user";
	}

	/* (non-Javadoc)
	 * @see br.furb.diswah.view.AbstractInternalPanel#getEntityClass()
	 */
	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

}