package br.furb.diswah.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

import br.furb.diswah.model.enums.MeasurementUnit;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
@Entity
@AccessType("field")
@Table(name = "product")
public class Product extends BasicEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@Enumerated(EnumType.ORDINAL)
    @Column(name="tp_measurement_unit", length=1)
	private MeasurementUnit measurementUnit;
	
	@NotNull
    @ForeignKey(name="fk_product_classification")
    @ManyToOne(targetEntity= Classification.class, cascade= CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name="classification_id_classification", nullable=false)
    private Classification classification;
	
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

	public MeasurementUnit getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(MeasurementUnit measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}
	
}