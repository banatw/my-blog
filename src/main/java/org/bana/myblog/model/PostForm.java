package org.bana.myblog.model;

import javax.validation.constraints.NotEmpty;

// import org.hibernate.validator.constraints.NotEmpty;

public class PostForm {
	private String idPost;

	@NotEmpty(message = "Title tidak boleh Kosong")
	private String postTitle;

	private String postSubTitle;

	@NotEmpty(message = "Date tidak boleh Kosong")
	private String postDate;

	//private String postTime;

	@NotEmpty(message = "Content tidak boleh Kosong")
	private String postContent;

	@NotEmpty(message = "Category tidak boleh Kosong")
	private String idCategory;

	public PostForm() {
		// TODO Auto-generated constructor stub
	}

	public String getIdPost() {
		return idPost;
	}

	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public String getPostSubTitle() {
		return postSubTitle;
	}

	public void setPostSubTitle(String postSubTitle) {
		this.postSubTitle = postSubTitle;
	}

}
