package com.ppm.trelloclone.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "checklist")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Checklist extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "card_id")
	private Long cardId;
	private String title;
	private String item;
	private Integer position;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "card_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Card card_with_checklists;

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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Card getCard_with_checklists() {
		return card_with_checklists;
	}

	public void setCard_with_checklists(Card card_with_checklists) {
		this.card_with_checklists = card_with_checklists;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

}
