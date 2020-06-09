package com.ppm.trelloclone.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppm.trelloclone.models.TList;
import com.ppm.trelloclone.repositories.TListRepository;

@RestController
@RequestMapping("/lists")
public class TListController {
	@Autowired
	private TListRepository tListRepository;
	
	@PostMapping
	public TList create(@RequestBody final TList list) {
		return tListRepository.saveAndFlush(list);
	}
	
	@GetMapping
	public java.util.List<TList> list() {
		return tListRepository.findAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public TList get(@PathVariable Long id) {
		return tListRepository.getOne(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public TList update(@PathVariable Long id, @RequestBody TList list) {
		TList existingList = tListRepository.getOne(id);
		BeanUtils.copyProperties(list, existingList, "id", "date_created");
		return tListRepository.saveAndFlush(existingList);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		tListRepository.deleteById(id);
	}
	
	@RequestMapping(value = "{id}/status/{status}", method = RequestMethod.PUT)
	public TList changeStatus(@PathVariable Long id, @PathVariable Byte status) {
		TList list = tListRepository.getOne(id);
		list.setStatus(status);
		return tListRepository.saveAndFlush(list);
	}
	

}
