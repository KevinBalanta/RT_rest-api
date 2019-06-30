/**
 * 
 */
package com.co.redtutores.rest_api.commons.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author Santiago 
 *
 */
public class ClientsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2975203438981088310L;
	
	private String clientCode;
	
	private String clientName;
	
	private String lastName;
	//account
	private String username;
	
	private String password;
	//
	private String city;
	
	private String state;
	
	private String country;
	
	private Date birthday;
	
	private String phoneNumber;
	
	private String semesterNumber;
	
	private String institution;
	
	
	
	public ClientsDTO() {
		
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSemesterNumber() {
		return semesterNumber;
	}

	public void setSemesterNumber(String semesterNumber) {
		this.semesterNumber = semesterNumber;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	

}
