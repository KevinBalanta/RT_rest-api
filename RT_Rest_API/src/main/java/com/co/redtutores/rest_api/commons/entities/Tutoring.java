package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the tutorings database table.
 * 
 */
@Entity
@Table(name="tutorings")
@NamedQuery(name="Tutoring.findAll", query="SELECT t FROM Tutoring t")
public class Tutoring implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tutoring_id", unique=true, nullable=false)
	private Integer tutoringId;

	@Column(name="tutoring_assistants", nullable=false)
	private Integer tutoringAssistants;

	@Column(name="tutoring_cost", nullable=false, precision=10, scale=2)
	private BigDecimal tutoringCost;

	@Column(name="tutoring_realization", nullable=false)
	private Timestamp tutoringRealization;

	@Column(name="tutoring_score")
	private Integer tutoringScore;

	//bi-directional many-to-one association to Client
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client_id", nullable=false)
	private Client client;

	//bi-directional many-to-one association to StateType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state_type_id", nullable=false)
	private StateType stateType;

	//bi-directional many-to-one association to Subject
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subject_id")
	private Subject subject;

	//bi-directional many-to-one association to Tutor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tutor_id")
	private Tutor tutor;

	public Tutoring() {
	}

	public Integer getTutoringId() {
		return this.tutoringId;
	}

	public void setTutoringId(Integer tutoringId) {
		this.tutoringId = tutoringId;
	}

	public Integer getTutoringAssistants() {
		return this.tutoringAssistants;
	}

	public void setTutoringAssistants(Integer tutoringAssistants) {
		this.tutoringAssistants = tutoringAssistants;
	}

	public BigDecimal getTutoringCost() {
		return this.tutoringCost;
	}

	public void setTutoringCost(BigDecimal tutoringCost) {
		this.tutoringCost = tutoringCost;
	}

	public Timestamp getTutoringRealization() {
		return this.tutoringRealization;
	}

	public void setTutoringRealization(Timestamp tutoringRealization) {
		this.tutoringRealization = tutoringRealization;
	}

	public Integer getTutoringScore() {
		return this.tutoringScore;
	}

	public void setTutoringScore(Integer tutoringScore) {
		this.tutoringScore = tutoringScore;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public StateType getStateType() {
		return this.stateType;
	}

	public void setStateType(StateType stateType) {
		this.stateType = stateType;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Tutor getTutor() {
		return this.tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

}