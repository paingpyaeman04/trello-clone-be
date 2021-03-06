package com.ppm.trelloclone.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "account")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Account extends Auditable {
	@Id
	private String username;
	private String name;
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	private Byte verified = 0;
	
	@ManyToMany(mappedBy = "members")
	@JsonIgnoreProperties({"list", "members", "labels", "checklists"})
	private List<Card> cards;

	public Account() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Byte getVerified() {
		return verified;
	}

	public void setVerified(Byte verified) {
		this.verified = verified;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
