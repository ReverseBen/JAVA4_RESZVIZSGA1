package com.citec.model.entites;

public class Topic {

	private Integer id;
	private String username;
	private String topicTitle;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public Topic() {
	}

	public Topic(Integer id, String username, String topicTitle) {
		this.id = id;
		this.username = username;
		this.topicTitle = topicTitle;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", username=" + username + ", topicTitle=" + topicTitle + "]";
	}

}
