package org.event.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.websocket.ClientEndpoint;

@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	private String password;
	private boolean actives;
	private String role;

	public User() {
		super();
	}

	public User(String userName, String passwoord, boolean actives, String role) {
		super();
		this.userName = userName;
		this.password = passwoord;
		this.actives = actives;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passwoord) {
		this.password = passwoord;
	}

	public boolean getActives() {
		return actives;
	}

	public void setActives(boolean actives) {
		this.actives = actives;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
