package com.citec.model.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citec.model.entites.Post;

@Repository
public class PostRepository {

	@Autowired
	public JdbcTemplate template;

	public List<Post> allPostsOfTopic(Integer id) {
		String query = "SELECT * FROM post WHERE topic_id = ?";
		return template.query(query, new BeanPropertyRowMapper<>(Post.class), id);
	}

	public void createPostsToTopic(Post p) {
		String query = "INSERT INTO post (topic_id,username, post_title, post_text) VALUES (?,?,?,?)";
		template.update(query, p.getTopicId(), p.getUsername(), p.getPostTitle(), p.getPostText());
	}

	public List<Post> searchPost(Integer topicId, String queryString) {
		String query = "SELECT * FROM post WHERE post.topic_id = ? AND (post.post_title LIKE ? OR post.username LIKE ? OR post.post_text LIKE ?)";
		String qq = '%' + queryString + '%';
		return template.query(query, new Object[] { topicId, qq, qq, qq }, new BeanPropertyRowMapper<>(Post.class));
	}

}
