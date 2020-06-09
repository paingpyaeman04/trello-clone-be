package com.ppm.trelloclone.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "card")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Card extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private Date due_date;
	private Byte position;
	private Byte status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "list_id", nullable = false)
	@JsonIgnoreProperties("cards")
	private TList list;

	@ManyToMany
	@JoinTable(
		name = "card_member",
		joinColumns = @JoinColumn(name = "card_id"),
		inverseJoinColumns = @JoinColumn(name = "account_username")
	)
	@JsonIgnoreProperties("cards")
	private List<Account> members;

	@ManyToMany
	@JoinTable(
		name = "card_label",
		joinColumns = @JoinColumn(name = "card_id"),
		inverseJoinColumns = @JoinColumn(name = "label_id")
	)
	private List<Label> labels = new ArrayList<>();

	@OneToMany(mappedBy = "card_with_checklists")
	@JsonIgnoreProperties({ "card_id", "card_with_checklists" })
	private List<Checklist> checklists;

	public Card() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public Byte getPosition() {
		return position;
	}

	public void setPosition(Byte position) {
		this.position = position;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public TList getList() {
		return list;
	}

	public void setList(TList list) {
		this.list = list;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Account> getMembers() {
		return members;
	}

	public void setMembers(List<Account> members) {
		this.members = members;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	public List<Checklist> getChecklists() {
		return checklists;
	}

	public void setChecklists(List<Checklist> checklists) {
		this.checklists = checklists;
	}

}
