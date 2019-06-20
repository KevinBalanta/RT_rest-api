package com.co.redtutores.rest_api.logic;

import com.co.redtutores.rest_api.commons.entities.Client;

public interface IClientsLogic {
	
	public void createClient(Client c) throws Exception;
	
	public Client findClient(String clientCode) throws Exception;

}
