package com.ppm.trelloclone.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppm.trelloclone.models.Account;
import com.ppm.trelloclone.models.Card;
import com.ppm.trelloclone.models.Label;
import com.ppm.trelloclone.models.TList;
import com.ppm.trelloclone.repositories.AccountRepository;
import com.ppm.trelloclone.repositories.CardRepository;
import com.ppm.trelloclone.repositories.LabelRepository;
import com.ppm.trelloclone.repositories.TListRepository;

@RestController
@RequestMapping(path = "/cards")
public class CardController {
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private TListRepository tListRepository;
	
	@Autowired
	private LabelRepository labelRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@PostMapping("add/{list_id}")
	public Card create(@PathVariable Long list_id, @RequestBody Card card) {
		TList list = tListRepository.getOne(list_id);
		card.setList(list);
		return cardRepository.saveAndFlush(card);
	}
	
	@GetMapping
	public List<Card> get() {
		return cardRepository.findAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Card get(@PathVariable Long id) {
		return cardRepository.getOne(id);
	}
	
	@RequestMapping(value = "update/{list_id}/{id}", method = RequestMethod.PUT)
	public Card update(@PathVariable Long id, @PathVariable Long list_id, @RequestBody Card card) {
		TList list = tListRepository.getOne(list_id);
		card.setList(list);
		Card existingCard = cardRepository.getOne(id);
		BeanUtils.copyProperties(card, existingCard, "id");
		return cardRepository.saveAndFlush(existingCard);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		cardRepository.deleteById(id);
	}
	
	@RequestMapping(value = "{id}/status/{status}", method = RequestMethod.PUT)
	public Card changeStatus(@PathVariable Long id, @PathVariable Byte status) {
		Card card = cardRepository.getOne(id);
		card.setStatus(status);
		return cardRepository.saveAndFlush(card);
	}
	
	@RequestMapping(value = "{id}/list/{list_id}/position/{position}", method = RequestMethod.PUT)
	public Card moveCard(@PathVariable Long id, @PathVariable Long list_id, @PathVariable Byte position) {
		TList list = tListRepository.getOne(list_id);
		Card card = cardRepository.getOne(id);
		card.setPosition(position);
		card.setList(list);
		return cardRepository.saveAndFlush(card);
	}
	
	@RequestMapping(value = "{id}/remove/label/{label_id}", method = RequestMethod.DELETE)
	public Card removeLabel(@PathVariable Long id, @PathVariable Long label_id) {
		Card card = cardRepository.getOne(id);
		Label label = labelRepository.getOne(label_id);
		card.getLabels().remove(label);
		return cardRepository.saveAndFlush(card);
	}
	
	@RequestMapping(value = "{id}/add/label/{label_id}", method = RequestMethod.PUT)
	public Card addLabel(@PathVariable Long id, @PathVariable Long label_id) {
		Card card = cardRepository.getOne(id);
		Label label = labelRepository.getOne(label_id);
		card.getLabels().add(label);
		return cardRepository.saveAndFlush(card);
	}
	
	@RequestMapping(value = "{id}/remove/member/{username}", method = RequestMethod.DELETE)
	public Card removeMember(@PathVariable Long id, @PathVariable String username) {
		Card card = cardRepository.getOne(id);
		Account member = accountRepository.getOne(username);
		card.getMembers().remove(member);
		return cardRepository.saveAndFlush(card);
	}
	
	@RequestMapping(value = "{id}/add/member/{username}", method = RequestMethod.PUT)
	public Card addMember(@PathVariable Long id, @PathVariable String username) {
		Card card = cardRepository.getOne(id);
		Account member = accountRepository.getOne(username);
		card.getMembers().add(member);
		return cardRepository.saveAndFlush(card);
	}

}

