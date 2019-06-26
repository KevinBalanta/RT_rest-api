package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clients database table.
 * 
 */
@Entity
@Table(name="clients")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="client_id", unique=true, nullable=false, length=40)
	private String clientId;

	@Temporal(TemporalType.DATE)
	@Column(name="client_birth")
	private Date clientBirth;

	@Column(name="client_lastname", nullable=false, length=40)
	private String clientLastname;

	@Column(name="client_name", nullable=false, length=40)
	private String clientName;

	@Column(name="client_phone", length=40)
	private String clientPhone;

	@Column(name="client_semester", nullable=false, length=6)
	private String clientSemester;

	//bi-directional one-to-one association to Account
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="account_username", nullable=false)
	private Account account;

	//bi-directional many-to-one association to City
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="city_id", nullable=false)
	private City city;

	//bi-directional many-to-one association to Institution
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="institution_id")
	private Institution institution;

	//bi-directional many-to-one association to Tutoring
	@OneToMany(mappedBy="client")
	private List<Tutoring> tutorings;

	public Client() {
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Date getClientBirth() {
		return this.clientBirth;
	}

	public void setClientBirth(Date clientBirth) {
		this.clientBirth = clientBirth;
	}

	public String getClientLastname() {
		return this.clientLastname;
	}

	public void setClientLastname(String clientLastname) {
		this.clientLastname = clientLastname;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPhone() {
		return this.clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientSemester() {
		return this.clientSemester;
	}

	public void setClientSemester(String clientSemester) {
		this.clientSemester = clientSemester;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public List<Tutoring> getTutorings() {
		return this.tutorings;
	}

	public void setTutorings(List<Tutoring> tutorings) {
		this.tutorings = tutorings;
	}

	public Tutoring addTutoring(Tutoring tutoring) {
		getTutorings().add(tutoring);
		tutoring.setClient(this);

		return tutoring;
	}

	public Tutoring removeTutoring(Tutoring tutoring) {
		getTutorings().remove(tutoring);
		tutoring.setClient(null);

		return tutoring;
	}

}