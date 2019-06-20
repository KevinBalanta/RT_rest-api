package com.co.redtutores.rest_api.delegate;

import com.co.redtutores.rest_api.commons.entities.Client;

public interface IClientsDelegate {
	
	public void createClient(Client c) throws Exception;
	
	public Client findClient(String clientCode) throws Exception;

}
