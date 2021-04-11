package com.citec.model.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.citec.model.entites.Topic;

@Repository
public class TopicRepository {

	@Autowired
	public JdbcTemplate template;

	public List<Topic> allTopic() {
		String query = "SELECT id,username,topic_title FROM topic";
		return template.query(query, new BeanPropertyRowMapper<>(Topic.class));
	}

	public void createTopic(Topic t) {
		String query = "INSERT INTO topic (username, topic_title) VALUES (?,?)";
		template.update(query, t.getUsername(), t.getTopicTitle());
	}

	public List<Topic> searchTopic(String queryString) {
		String query = "SELECT * FROM topic WHERE topic.topic_title LIKE ? OR topic.username LIKE ?";
		String qq = '%' + queryString + '%';
		return template.query(query, new Object[] { qq, qq }, new BeanPropertyRowMapper<>(Topic.class));
	}
}
