/**
 * 
 */
package com.co.redtutores.rest_api.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.*;
import org.springframework.stereotype.Repository;

import com.co.redtutores.rest_api.commons.entities.Client;

/**
 * @author Santiago
 *
 */
@Repository
public class ClientsDAO implements IClientsDAO {
	
	private final static Logger log = LoggerFactory.getLogger(ClientsDAO.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createClient(Client c) throws Exception {
		try {
			log.info("[Persistence] Client Code: " + c.getClientId());
			log.info("[Persistence] Client Name: " + c.getClientName());
			entityManager.persist(c);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("An error ocurred at the persistence layer: " + e.getMessage());
		}

	}

	@Override
	public Client findClient(String clientCode) throws Exception {
		Client required = null;
		required = entityManager.find(Client.class, clientCode);
		return required;
	}

}
