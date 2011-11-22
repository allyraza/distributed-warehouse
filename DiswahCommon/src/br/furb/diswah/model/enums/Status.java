package br.furb.diswah.model.enums;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public enum Status {
	
	ACTIVE("ativo"),
	INACTIVE("inativo");
	
	private String description;
	
	private Status(String description){
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
}