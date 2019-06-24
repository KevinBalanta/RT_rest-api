package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the state_type database table.
 * 
 */
@Entity
@Table(name="state_type")
@NamedQuery(name="StateType.findAll", query="SELECT s FROM StateType s")
public class StateType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="state_type_id", unique=true, nullable=false)
	private Integer stateTypeId;

	@Column(name="state_type_name", nullable=false, length=40)
	private String stateTypeName;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="stateType")
	private List<Account> accounts;

	//bi-directional many-to-one association to Phase
	@OneToMany(mappedBy="stateType")
	private List<Phase> states;

	//bi-directional many-to-one association to Tutoring
	@OneToMany(mappedBy="stateType")
	private List<Tutoring> tutorings;

	public StateType() {
	}

	public Integer getStateTypeId() {
		return this.stateTypeId;
	}

	public void setStateTypeId(Integer stateTypeId) {
		this.stateTypeId = stateTypeId;
	}

	public String getStateTypeName() {
		return this.stateTypeName;
	}

	public void setStateTypeName(String stateTypeName) {
		this.stateTypeName = stateTypeName;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setStateType(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setStateType(null);

		return account;
	}

	public List<Phase> getStates() {
		return this.states;
	}

	public void setStates(List<Phase> states) {
		this.states = states;
	}

	public Phase addState(Phase state) {
		getStates().add(state);
		state.setStateType(this);

		return state;
	}

	public Phase removeState(Phase state) {
		getStates().remove(state);
		state.setStateType(null);

		return state;
	}

	public List<Tutoring> getTutorings() {
		return this.tutorings;
	}

	public void setTutorings(List<Tutoring> tutorings) {
		this.tutorings = tutorings;
	}

	public Tutoring addTutoring(Tutoring tutoring) {
		getTutorings().add(tutoring);
		tutoring.setStateType(this);

		return tutoring;
	}

	public Tutoring removeTutoring(Tutoring tutoring) {
		getTutorings().remove(tutoring);
		tutoring.setStateType(null);

		return tutoring;
	}

}