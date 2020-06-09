package com.ppm.trelloclone.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "list")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TList extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Integer position;
	private Byte status;

	@OneToMany(mappedBy = "list")
	@JsonIgnoreProperties("list")
	private List<Card> cards;

	public TList() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public java.util.List<Card> getCards() {
		return cards;
	}

	public void setCards(java.util.List<Card> cards) {
		this.cards = cards;
	}


}
