package org.event.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Members implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String LastName;
	private boolean isMember;
	
	public Members() {
		super();
	}

	public Members(String firstName, String lastName, boolean isMember) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.isMember = isMember;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
	
}
