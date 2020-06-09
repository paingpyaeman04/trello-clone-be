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

import com.ppm.trelloclone.models.Label;
import com.ppm.trelloclone.repositories.LabelRepository;

@RestController
@RequestMapping(path = "/labels")
public class LabelController {
	@Autowired
	private LabelRepository labelRepository;
	
	@PostMapping
	public Label create(@RequestBody Label label) {
		return labelRepository.saveAndFlush(label);
	}
	
	@GetMapping
	public List<Label> get() {
		return labelRepository.findAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Label getById(@PathVariable Long id) {
		return labelRepository.getOne(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Label update(@PathVariable Long id, @RequestBody Label label) {
		Label existingLabel = labelRepository.getOne(id);
		BeanUtils.copyProperties(label, existingLabel, "id");
		return labelRepository.saveAndFlush(existingLabel);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		labelRepository.deleteById(id);
	}
	
}





