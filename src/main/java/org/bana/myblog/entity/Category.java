package org.bana.myblog.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idCategory;

	@Column(length = 30)
	private String categoryDescription;

	@Temporal(TemporalType.TIMESTAMP)
	private Date auditDate;

	@Column(length = 30)
	private String auditUser;

	@OneToMany(mappedBy = "category")
	private List<Post> posts;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Category(Integer idCategory, String categoryDescription, Date auditDate, String auditUser,
			List<Post> posts) {
		super();
		this.idCategory = idCategory;
		this.categoryDescription = categoryDescription;
		this.auditDate = auditDate;
		this.auditUser = auditUser;
		this.posts = posts;
	}

}
