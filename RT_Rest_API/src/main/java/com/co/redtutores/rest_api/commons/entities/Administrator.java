package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the administrators database table.
 * 
 */
@Entity
@Table(name="administrators")
@NamedQuery(name="Administrator.findAll", query="SELECT a FROM Administrator a")
public class Administrator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="administrator_id", unique=true, nullable=false, length=40)
	private String administratorId;

	@Column(name="administrator_name", nullable=false, length=40)
	private String administratorName;

	//bi-directional one-to-one association to Account
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="account_username", nullable=false)
	private Account account;

	public Administrator() {
	}

	public String getAdministratorId() {
		return this.administratorId;
	}

	public void setAdministratorId(String administratorId) {
		this.administratorId = administratorId;
	}

	public String getAdministratorName() {
		return this.administratorName;
	}

	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}