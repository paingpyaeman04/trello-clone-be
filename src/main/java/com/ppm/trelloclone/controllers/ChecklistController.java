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

import com.ppm.trelloclone.models.Auditable;
import com.ppm.trelloclone.models.Checklist;
import com.ppm.trelloclone.repositories.ChecklistRepository;

@RestController
@RequestMapping(path = "/checklists")
public class ChecklistController extends Auditable {
	@Autowired
	private ChecklistRepository checklistRepository;
	
	@PostMapping
	public Checklist create(@RequestBody Checklist checklist) {
		return checklistRepository.saveAndFlush(checklist);
	}
	
	@GetMapping
	public List<Checklist> get() {
		return checklistRepository.findAll();
	}
	
	@GetMapping(value = "{id}")
	public Checklist getById(@PathVariable Long id) {
		return checklistRepository.getOne(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Checklist update(@PathVariable Long id, @RequestBody Checklist checklist) {
		Checklist existingChecklist = checklistRepository.getOne(id);
		BeanUtils.copyProperties(checklist, existingChecklist, "id", "card_id");
		return checklistRepository.saveAndFlush(existingChecklist);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		checklistRepository.deleteById(id);
	}
	
	@RequestMapping(value = "{card_id}/remove/checklist", method = RequestMethod.DELETE)
	public void removeChecklist(@PathVariable Long card_id) {
		List<Checklist> checklists = checklistRepository.findByCardId(card_id);
		checklistRepository.deleteAll(checklists);
	}
	
}













