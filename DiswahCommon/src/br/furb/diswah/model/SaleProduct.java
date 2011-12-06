package br.furb.diswah.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

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
	
	@Column(name="cd_sale", nullable=false)
    private Long sale;
	
	@Column(name="cd_product", nullable=false)
    private Long product;
	
	/*@NotNull
    @ForeignKey(name="fk_saleproduct_sale")
    @ManyToOne(targetEntity= Sale.class, cascade= CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name="client_id_client", nullable=false)
    private Sale sale;
	
	@NotNull
    @ForeignKey(name="fk_saleproduct_product")
    @ManyToOne(targetEntity= Product.class, cascade= CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name="product_id_product", nullable=false)
    private Product product;*/
	
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Long getSale() {
		return sale;
	}

	public void setSale(Long sale) {
		this.sale = sale;
	}

	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

}