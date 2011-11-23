package br.furb.diswah.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.AccessType;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
@Entity
@AccessType("field")
@Table(name = "user")
public class User extends BasicEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_user", nullable = false)
	private Long id;
	
    @Column(name = "ds_login", nullable = false, length = 30)
    private String login;
	
    @Column(name = "ds_password", nullable = false, length = 30)
    private String password;
	
    @Column(name = "ds_email", nullable = false, length = 30)
    private String email;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}