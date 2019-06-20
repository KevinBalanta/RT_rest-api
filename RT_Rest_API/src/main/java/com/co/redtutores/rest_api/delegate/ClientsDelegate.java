/**
 * 
 */
package com.co.redtutores.rest_api.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.redtutores.rest_api.commons.entities.Client;
import com.co.redtutores.rest_api.logic.IClientsLogic;

/**
 * @author Santiago
 *
 */
@Component
public class ClientsDelegate implements IClientsDelegate {
	
	@Autowired
	private IClientsLogic clientsLogic;
	
	public void createClient(Client c) throws Exception {
		clientsLogic.createClient(c);
	}

	@Override
	public Client findClient(String clientCode) throws Exception {
		Client required = clientsLogic.findClient(clientCode);
		return required;
	}
}
