package com.citec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citec.model.entites.Comment;
import com.citec.services.Services;

@Controller
@RequestMapping(path = "/topic/{topic_id}/post/{post_id}/")
public class CommentController {

	@Autowired
	private Services services;

	@GetMapping("/comments")
	public String listComments(@PathVariable("topic_id") Integer topicId, @PathVariable("post_id") Integer postId,
			Model model) {
		model.addAttribute("comments", services.allCommentsOfPost(postId));
		model.addAttribute("topic_id", topicId);
		model.addAttribute("post_id", postId);
		return "comment/comment";
	}

	@GetMapping("/comments/new")
	public String listCommentsToPost(@PathVariable("topic_id") Integer topicId, @PathVariable("post_id") Integer postId,
			Model model) {
		model.addAttribute("comments", new Comment());
		model.addAttribute("topic_id", topicId);
		model.addAttribute("post_id", postId);
		return "comment/new";
	}

	@PostMapping("/comments/new")
	public String addCommentsToPost(@PathVariable("topic_id") Integer topicId, @PathVariable("post_id") Integer postId,
			Model model, @ModelAttribute Comment c) {
		// model.addAttribute("topic_id",topicId);
		// model.addAttribute("post_id",postId);
		c.setPostId(postId);
		services.createCommentsToPost(c);
		return "redirect:/topic/" + topicId + "/post/" + postId + "/comments";
	}

}
