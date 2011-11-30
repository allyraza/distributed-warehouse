package br.furb.diswah.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
@Entity
@AccessType("field")
@Table(name = "client")
public class Client extends BasicEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_client", nullable = false)
    private Long id;
	
	@NotBlank
	@Column(name = "ds_name", nullable = false, length = 40)
    private String name;
	
	@NotBlank
	@Column(name = "ds_name", nullable = false, length = 200)
    private String address;
	
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}