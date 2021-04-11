package com.citec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.citec.model.entites.Topic;
import com.citec.services.Services;

@Controller
@RequestMapping(path = "/topic/")
public class TopicController {

	@Autowired
	private Services services;

	@GetMapping("/")
	public String listTopic(Model model) {
		model.addAttribute("topics", services.allTopic());
		return "topic/topic";
	}

	@GetMapping("/search")
	public String searchtTopic(Model model, @RequestParam("q") String queryString) {
		model.addAttribute("topics", services.searchTopic(queryString));
		model.addAttribute("queryString", queryString);
		return "topic/topic";
	}

	@GetMapping("/new")
	public String createTopic(Model model) {
		model.addAttribute("topic", new Topic());
		return "topic/new";
	}

	@PostMapping("/new")
	public String newTopic(@ModelAttribute Topic t) {
		services.createTopic(t);
		return "redirect:/topic/";
	}

}
