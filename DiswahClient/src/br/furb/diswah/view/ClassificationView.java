package br.furb.diswah.view;

import br.furb.diswah.model.Classification;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class ClassificationView extends AbstractInternalPanel<Classification> {

	/**
	 * 
	 */
	public ClassificationView() {
		super();
	}
	
	@Override
	protected void createComponents() {
		// TODO Auto-generated method stub
	}

	@Override
	protected String getMessagesProperty() {
		return "classification";
	}

	@Override
	protected Class<Classification> getEntityClass() {
		return Classification.class;
	}
	
}