package com.co.redtutores.rest_api.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.*;
import org.springframework.stereotype.Repository;

import com.co.redtutores.rest_api.commons.entities.Account;
/**
 * 
 * @author kevin david
 *
 */
@Repository
public class AccountDAO implements IAccountDAO{
	
private final static Logger log = LoggerFactory.getLogger(AccountDAO.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void createAccount(Account ac) throws Exception {
		// TODO Auto-generated method stub
		try {
			log.info("[Persistence] Account username:"+ ac.getAccountUsername());
			log.info("[Persistence] Account password"+ "************ "+ !ac.getAccountPassword().isEmpty());
			entityManager.persist(ac);
		}catch(Exception e) {
			e.printStackTrace();
			log.error("error at Account persistence layer : " + e.getMessage());
			throw new Exception("An error ocurred at the persistence layer: " + e.getMessage());
		}
		
	}

	@Override
	public Account findAccountByUserName(String username) throws Exception {
		// TODO Auto-generated method stub
		Account req = null;
		req = entityManager.find(Account.class, username);
		
		return req;
	}

}
