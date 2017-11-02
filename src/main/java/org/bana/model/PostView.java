package org.bana.model;

public class PostView {
	
	private String idPost;
	
	private String postTitle;
	
	private String postDate;
	
	private String postSubTitle;
	
	private String categoryDescription;
	
	private String postContent;
	
	private String authorName;
	
	public PostView() {
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

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public PostView(String idPost, String postTitle, String postDate, String categoryDescription) {
		super();
		this.idPost = idPost;
		this.postTitle = postTitle;
		this.postDate = postDate;
		this.categoryDescription = categoryDescription;
	}

	

	public String getPostSubTitle() {
		return postSubTitle;
	}

	public void setPostSubTitle(String postSubTitle) {
		this.postSubTitle = postSubTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
