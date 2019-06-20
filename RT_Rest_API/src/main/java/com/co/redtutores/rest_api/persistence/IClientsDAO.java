package com.co.redtutores.rest_api.persistence;

import com.co.redtutores.rest_api.commons.entities.Client;

public interface IClientsDAO {
	
	public void createClient(Client c) throws Exception;
	
	public Client findClient(String clientCode) throws Exception;

}
