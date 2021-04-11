package com.citec.model.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citec.model.entites.Comment;

@Repository
public class CommentRepository {

	@Autowired
	public JdbcTemplate template;

	public List<Comment> allCommentsOfPost(Integer pid) {
		String query = "SELECT * FROM comment WHERE post_id = ?";
		return template.query(query, new BeanPropertyRowMapper<>(Comment.class), pid);
	}

	public void createCommentsToPost(Comment c) {
		String query = "INSERT INTO comment(post_id,username, comment_text) VALUES (?,?,?)";
		template.update(query, c.getPostId(), c.getUsername(), c.getCommentText());
	}
}
