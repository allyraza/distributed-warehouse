package br.furb.diswah.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@NotNull
    @ForeignKey(name="fk_sale_client")
    @ManyToOne(targetEntity= Client.class, cascade= CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name="client_id_client", nullable=false)
    private Client client;
	
	@ForeignKey(name = "fk_saleproduct_sale")
	@OneToMany(targetEntity = SaleProduct.class, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "sale")
	private List<SaleProduct> saleProducts;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<SaleProduct> getSaleProducts() {
		return saleProducts;
	}

	public void setSaleProducts(List<SaleProduct> saleProducts) {
		this.saleProducts = saleProducts;
	}

}