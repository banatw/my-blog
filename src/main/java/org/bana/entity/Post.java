package org.bana.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post {
	@Id
	private String idPost;
	
	@Column(length=255)
	private String postTitle;
	
	@Column(length=255)
	private String postSubTitle;
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date postDate;
	
	@Column(columnDefinition="TEXT")
	private String postContent;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date auditDate;

	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Author author;

	public Post() {
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

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Post(String idPost, String postTitle, Date postDate, String postContent, Date auditDate, String auditUser,
			Category category, Author author) {
		super();
		this.idPost = idPost;
		this.postTitle = postTitle;
		this.postDate = postDate;
		this.postContent = postContent;
		this.auditDate = auditDate;
		this.category = category;
		this.author = author;
	}

	public String getPostSubTitle() {
		return postSubTitle;
	}

	public void setPostSubTitle(String postSubTitle) {
		this.postSubTitle = postSubTitle;
	}

}
