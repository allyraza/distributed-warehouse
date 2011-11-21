package br.furb.diswah.model;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class User extends BasicEntity {

	private String login;
	
	private String password;
	
	private String email;
	
	private Boolean active;

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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}