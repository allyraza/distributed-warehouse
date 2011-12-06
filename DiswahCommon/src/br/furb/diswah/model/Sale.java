package br.furb.diswah.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.AccessType;
import org.hibernate.annotations.ForeignKey;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
@Entity
@AccessType("field")
@Table(name = "sale")
public class Sale extends BasicEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_sale", nullable = false)
    private Long id;
	
	
	@Column(name = "cd_client")
    private Long client;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Long getClient() {
		return client;
	}

	public void setClient(Long client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "Id: "+id+" | Nome: "+client;
	}

}