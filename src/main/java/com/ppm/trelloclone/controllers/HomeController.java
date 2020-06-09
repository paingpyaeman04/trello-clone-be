package com.ppm.trelloclone.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.version}")
	private String appVersion;
	
	@GetMapping
	@RequestMapping("/")
	public Map<String, String> getStatus() {
		Map<String, String> map = new HashMap<>();
		map.put("app-version", appVersion);
		map.put("app-name", appName);
		return map;
	}
	

}
