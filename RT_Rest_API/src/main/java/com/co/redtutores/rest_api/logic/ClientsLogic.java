/**
 * 
 */
package com.co.redtutores.rest_api.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.co.redtutores.rest_api.commons.entities.Client;
import com.co.redtutores.rest_api.persistence.IClientsDAO;

/**
 * @author Santiago
 *
 */
@Service
public class ClientsLogic implements IClientsLogic {
	
	@Autowired
	private IClientsDAO clientsDAO;

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
	public void createClient(Client c) throws Exception {
		try {
			clientsDAO.createClient(c);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Client findClient(String clientCode) throws Exception {
		if (clientCode == null) {
			throw new Exception("Can not find the client: client code is null");
		}
		
		if (clientCode.equals("")) {
			throw new Exception("Can not find the client: client code is empty");
		}
		
		Client required = clientsDAO.findClient(clientCode);
		return required;
	}

}
