package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the account_types database table.
 * 
 */
@Entity
@Table(name="account_types")
@NamedQuery(name="AccountType.findAll", query="SELECT a FROM AccountType a")
public class AccountType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="acnt_type_id", unique=true, nullable=false)
	private Integer acntTypeId;

	@Column(name="acnt_type_name", nullable=false, length=40)
	private String acntTypeName;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="accountType")
	private List<Account> accounts;

	public AccountType() {
	}

	public Integer getAcntTypeId() {
		return this.acntTypeId;
	}

	public void setAcntTypeId(Integer acntTypeId) {
		this.acntTypeId = acntTypeId;
	}

	public String getAcntTypeName() {
		return this.acntTypeName;
	}

	public void setAcntTypeName(String acntTypeName) {
		this.acntTypeName = acntTypeName;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setAccountType(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setAccountType(null);

		return account;
	}

}