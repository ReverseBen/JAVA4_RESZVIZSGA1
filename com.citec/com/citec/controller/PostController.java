package com.citec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.citec.model.entites.Post;
import com.citec.services.Services;

@Controller
@RequestMapping(path = "/topic/{id}")
public class PostController {

	@Autowired
	private Services services;

	@GetMapping("/posts")
	public String listPost(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("posts", services.allPostsOfTopic(id));
		model.addAttribute("topic_id", id);
		return "post/post";
	}

	@GetMapping("/posts/search")
	public String searchtTopic(@PathVariable("id") Integer topicId, Model model,
			@RequestParam("q") String queryString) {
		model.addAttribute("posts", services.searchPost(topicId, queryString));
		model.addAttribute("topic_id", topicId);
		model.addAttribute("queryString", queryString);
		return "post/post";
	}

	@GetMapping("/posts/new")
	public String postPageLoad(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("topic_id", id);
		model.addAttribute("posts", new Post());
		return "post/new";
	}

	// TODO: forwarding error --> Bad Request
	@PostMapping("/posts/new")
	public String newPost(@PathVariable("id") Integer id, /* Model model, */ @ModelAttribute Post p) {
		// model.addAttribute("topic_id", id);
		p.setTopicId(id);
		services.createPostsToTopic(p);
		return "redirect:/topic/" + id + "/posts";
	}

}
