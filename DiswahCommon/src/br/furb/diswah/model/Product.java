package br.furb.diswah.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.AccessType;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
@Entity
@AccessType("field")
@Table(name = "product")
public class Product extends BasicEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_product", nullable = false)
    private Long id;

	@NotNull
	@Column(name="cd_product", nullable=false)
    private Long code;
	
	@NotBlank
	@Column(name = "ds_name", nullable = false, length = 40)
    private String name;
	
	@NotBlank
	@Column(name = "ds_description", nullable = false, length = 200)
    private String description;
	
	
	@Column(name="cd_classification", nullable=false)
    private Long classification;
	
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(Long code) {
		this.code = code;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return classification
	 */
	public Long getClassification() {
		return classification;
	}

	/**
	 * @param classification
	 */
	public void setClassification(Long classification) {
		this.classification = classification;
	}
	
	@Override
	public String toString() {
		return "Id: "+id+" | Nome: "+name+ " | Descrição: "+description;
	}
	
}