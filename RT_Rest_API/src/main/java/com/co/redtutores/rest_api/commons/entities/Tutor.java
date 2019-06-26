package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tutors database table.
 * 
 */
@Entity
@Table(name="tutors")
@NamedQuery(name="Tutor.findAll", query="SELECT t FROM Tutor t")
public class Tutor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tutor_id", unique=true, nullable=false, length=40)
	private String tutorId;

	@Column(name="tutor_name", nullable=false, length=40)
	private String tutorName;

	//bi-directional many-to-one association to Tutoring
	@OneToMany(mappedBy="tutor")
	private List<Tutoring> tutorings;

	//bi-directional one-to-one association to Account
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="account_username", nullable=false)
	private Account account;

	public Tutor() {
	}

	public String getTutorId() {
		return this.tutorId;
	}

	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}

	public String getTutorName() {
		return this.tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public List<Tutoring> getTutorings() {
		return this.tutorings;
	}

	public void setTutorings(List<Tutoring> tutorings) {
		this.tutorings = tutorings;
	}

	public Tutoring addTutoring(Tutoring tutoring) {
		getTutorings().add(tutoring);
		tutoring.setTutor(this);

		return tutoring;
	}

	public Tutoring removeTutoring(Tutoring tutoring) {
		getTutorings().remove(tutoring);
		tutoring.setTutor(null);

		return tutoring;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}