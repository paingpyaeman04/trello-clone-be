package com.ppm.trelloclone.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "label")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Label extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String color;
	private Byte status = 1;
	
	@ManyToMany(mappedBy = "labels")
	@JsonIgnore
	private List<Card> cards_with_labels = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public List<Card> getCards_with_labels() {
		return cards_with_labels;
	}

	public void setCards_with_labels(List<Card> cards_with_labels) {
		this.cards_with_labels = cards_with_labels;
	}

}
