package com.citec.model.entites;

public class Post {

	private Integer id;
	private Integer topicId;
	private String username;
	private String postTitle;
	private String postText;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public Post() {
	}

	public Post(Integer id, Integer topicId, String username, String postTitle, String postText) {
		this.id = id;
		this.topicId = topicId;
		this.username = username;
		this.postTitle = postTitle;
		this.postText = postText;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", topicId=" + topicId + ", username=" + username + ", postTitle=" + postTitle
				+ ", postText=" + postText + "]";
	}

}
