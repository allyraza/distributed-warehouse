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
		
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return sale
	 */
	public Long getSale() {
		return sale;
	}

	/**
	 * @param sale
	 */
	public void setSale(Long sale) {
		this.sale = sale;
	}

	/**
	 * @return product
	 */
	public Long getProduct() {
		return product;
	}

	/**
	 * @param product
	 */
	public void setProduct(Long product) {
		this.product = product;
	}
	
	@Override
	public String toString() {
		return "Id: "+id+" | Produto: "+product;
	}

}