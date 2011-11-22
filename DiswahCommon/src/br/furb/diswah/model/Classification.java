package br.furb.diswah.model;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class Classification extends BasicEntity {

	private Long id;
	
	private Long code;
	
	private String name;
	
	private String description;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}