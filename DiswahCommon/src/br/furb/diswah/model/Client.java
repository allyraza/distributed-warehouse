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
	@Column(name = "ds_address", nullable = false, length = 200)
    private String address;
	
	/*@ForeignKey(name = "fk_sale_client")
	@OneToMany(targetEntity = Sale.class, cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "client")
	private List<Sale> sales;*/
	
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

	/*public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}*/
	
	@Override
	public String toString() {
		return "Id: "+id+" | Nome: "+name+" | Endereço: "+address;
	}
	
}