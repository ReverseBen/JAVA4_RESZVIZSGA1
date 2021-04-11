package com.citec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citec.model.entites.Comment;
import com.citec.model.entites.Post;
import com.citec.model.entites.Topic;
import com.citec.model.repository.CommentRepository;
import com.citec.model.repository.PostRepository;
import com.citec.model.repository.TopicRepository;

@Service
public class Services {

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	CommentRepository commentRepository;

	public List<Topic> allTopic() {
		return topicRepository.allTopic();
	}

	public void createTopic(Topic t) {
		topicRepository.createTopic(t);
	}

	public List<Post> allPostsOfTopic(Integer id) {
		return postRepository.allPostsOfTopic(id);
	}

	public void createPostsToTopic(Post p) {
		postRepository.createPostsToTopic(p);
	}

	public List<Comment> allCommentsOfPost(Integer pid) {
		return commentRepository.allCommentsOfPost(pid);
	}

	public void createCommentsToPost(Comment c) {
		commentRepository.createCommentsToPost(c);
	}

	public List<Topic> searchTopic(String queryString) {
		return topicRepository.searchTopic(queryString);
	}

	public List<Post> searchPost(Integer topicId, String queryString) {
		return postRepository.searchPost(topicId, queryString);
	}

}
