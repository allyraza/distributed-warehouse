package br.furb.diswah.model;

import java.util.Date;

/**
 * A base para todas as entidades do sistema.
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public abstract class BasicEntity {

	
	/**
	 * id - o identificador da entidade
	 */
	private Long id; 
	
	/**
	 * creation - a data de criação do registro
	 */
	private Date creation;
	
	/**
	 * alter - a data da ultima alteração do registro
	 */
	private Date alter;

	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public Date getCreation() {
		return creation;
	}

	/**
	 * @param creation
	 */
	public void setCreation(Date creation) {
		this.creation = creation;
	}

	/**
	 * @return
	 */
	public Date getAlter() {
		return alter;
	}

	/**
	 * @param alter
	 */
	public void setAlter(Date alter) {
		this.alter = alter;
	}

}