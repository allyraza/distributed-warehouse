package br.furb.diswah;

import java.util.Date;

import br.furb.diswah.model.User;

/**
 * 
 * @author André Felipe de Almeida {almeida.andref@gmail.com}
 */
public class UserSession {

	private static UserSession instance;
	
	public static UserSession getInstance(){
		if(instance == null)
			instance = new UserSession();
		
		return instance;	
	}
	
	private User user;
	private Date lastRequest;
	
	public UserSession() {
		this.user = null;
		this.lastRequest = new Date();
	}
	
	public void initSession(User user){
		this.user = user;
		lastRequest = new Date();
	}

	public void destroySession() {
		this.user = null;
		this.lastRequest = new Date();
	}

	public User getUser() {
		return user;
	}

	public Date getLastRequest() {
		return lastRequest;
	}

}