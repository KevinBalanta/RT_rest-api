package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Clients" database table.
 * 
 */
@Entity
@Table(name="\"Clients\"")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="client_code")
	private String clientCode;

	@Column(name="client_name")
	private String clientName;

	public Client() {
	}

	public String getClientCode() {
		return this.clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

}