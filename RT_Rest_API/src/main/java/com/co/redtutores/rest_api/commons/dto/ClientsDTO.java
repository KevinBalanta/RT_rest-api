/**
 * 
 */
package com.co.redtutores.rest_api.commons.dto;

import java.io.Serializable;

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
	
	

}
