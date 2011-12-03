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
@Table(name = "sale_product")
public class SaleProduct extends BasicEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_sale_product", nullable = false)
    private Long id;
	
	@NotNull
    @ForeignKey(name="fk_saleproduct_sale")
    @ManyToOne(targetEntity= Sale.class, cascade= CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name="client_id_client", nullable=false)
    private Sale sale;
	
	@NotNull
    @ForeignKey(name="fk_saleproduct_product")
    @ManyToOne(targetEntity= Product.class, cascade= CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name="product_id_product", nullable=false)
    private Product product;
	
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}