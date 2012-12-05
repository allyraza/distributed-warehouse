package br.furb.diswah.model.enums;

import br.furb.diswah.resource.MessageBundle;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public enum Status {
	
	/**
	 * 
	 */
	ACTIVE("status.active"),
	/**
	 * 
	 */
	INACTIVE("status.inactive");
	
	private String description;
	
	private Status(String description){
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return MessageBundle.getMessage(description);
	}
	
}