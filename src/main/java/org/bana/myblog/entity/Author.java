package org.bana.myblog.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Author {
	@Id
	private String username;

	@Column(length = 100)
	private String password;

	@Column(length = 30)
	private String authorName;

	@ManyToOne
	private Role role;

	@Temporal(TemporalType.TIMESTAMP)
	private Date auditDate;

	@Column(length = 30)
	private String auditUser;

	@OneToMany(mappedBy = "author")
	private List<Post> posts;

	public Author() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public Author(String username, String password, String authorName, Role role, Date auditDate, String auditUser,
			List<Post> posts) {
		super();
		this.username = username;
		this.password = password;
		this.authorName = authorName;
		this.role = role;
		this.auditDate = auditDate;
		this.auditUser = auditUser;
		this.posts = posts;
	}

}
