package com.co.redtutores.rest_api.commons.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cities database table.
 * 
 */
@Entity
@Table(name="cities")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CITIES_CITYID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CITIES_CITYID_GENERATOR")
	@Column(name="city_id", unique=true, nullable=false)
	private Integer cityId;

	@Column(name="city_name", nullable=false, length=40)
	private String cityName;

	//bi-directional many-to-one association to State
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state_id", nullable=false)
	private State state;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="city")
	private List<Client> clients;

	public City() {
	}

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setCity(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setCity(null);

		return client;
	}

}