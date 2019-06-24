package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the institutions database table.
 * 
 */
@Entity
@Table(name="institutions")
@NamedQuery(name="Institution.findAll", query="SELECT i FROM Institution i")
public class Institution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="institution_id", unique=true, nullable=false)
	private Integer institutionId;

	@Column(name="institution_name", nullable=false, length=40)
	private String institutionName;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="institution")
	private List<Client> clients;

	public Institution() {
	}

	public Integer getInstitutionId() {
		return this.institutionId;
	}

	public void setInstitutionId(Integer institutionId) {
		this.institutionId = institutionId;
	}

	public String getInstitutionName() {
		return this.institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setInstitution(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setInstitution(null);

		return client;
	}

}