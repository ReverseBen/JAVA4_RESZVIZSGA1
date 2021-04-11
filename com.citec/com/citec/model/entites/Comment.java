package com.citec.model.entites;

public class Comment {

	private Integer id;
	private Integer postId;
	private String username;
	private String commentText;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Comment() {
	}

	public Comment(Integer id, Integer postId, String username, String commentText) {
		this.id = id;
		this.postId = postId;
		this.username = username;
		this.commentText = commentText;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", postId=" + postId + ", username=" + username + ", commentText=" + commentText
				+ "]";
	}

}
