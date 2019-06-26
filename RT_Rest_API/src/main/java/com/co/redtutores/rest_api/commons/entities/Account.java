package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the accounts database table.
 * 
 */
@Entity
@Table(name="accounts")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="account_username", unique=true, nullable=false, length=40)
	private String accountUsername;

	@Column(name="account_password", nullable=false, length=256)
	private String accountPassword;

	//bi-directional many-to-one association to AccountType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="acnt_type_id", nullable=false)
	private AccountType accountType;

	//bi-directional many-to-one association to StateType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state_type_id", nullable=false)
	private StateType stateType;

	//bi-directional one-to-one association to Administrator
	@OneToOne(mappedBy="account", fetch=FetchType.LAZY)
	private Administrator administrator;

	//bi-directional one-to-one association to Client
	@OneToOne(mappedBy="account", fetch=FetchType.LAZY)
	private Client client;

	//bi-directional one-to-one association to Tutor
	@OneToOne(mappedBy="account", fetch=FetchType.LAZY)
	private Tutor tutor;

	public Account() {
	}

	public String getAccountUsername() {
		return this.accountUsername;
	}

	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}

	public String getAccountPassword() {
		return this.accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public AccountType getAccountType() {
		return this.accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public StateType getStateType() {
		return this.stateType;
	}

	public void setStateType(StateType stateType) {
		this.stateType = stateType;
	}

	public Administrator getAdministrator() {
		return this.administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Tutor getTutor() {
		return this.tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

}