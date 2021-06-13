package com.board.photo.web.controller;

import java.util.Map;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@EnableJpaAuditing
public class IndexController {
	
	@GetMapping({"/", "/index"})
	public String index(Model model) {
		
		return "index";
	}
	
	@GetMapping(value = "/{1}/{2}")
	public String getPage(@PathVariable Map<String,Object> pathVal) {
		return pathVal.get("1") + "/" + pathVal.get("2");
	}
}
