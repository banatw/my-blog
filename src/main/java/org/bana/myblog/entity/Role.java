package org.bana.myblog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idRole;

	@Column(length = 30)
	private String roleName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date auditDate;

	@Column(length = 30)
	private String auditUser;

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public Role(Integer idRole, String roleName, Date auditDate, String auditUser) {
		super();
		this.idRole = idRole;
		this.roleName = roleName;
		this.auditDate = auditDate;
		this.auditUser = auditUser;
	}

}
