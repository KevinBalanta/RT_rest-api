package com.co.redtutores.rest_api.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.co.redtutores.rest_api.commons.entities.Account;
import com.co.redtutores.rest_api.persistence.IAccountDAO;
/**
 * 
 * @author kevin david
 *
 */
@Service
public class AccountLogic implements IAccountLogic{

	@Autowired
	private IAccountDAO accountDAO;
	
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
	public void createAccount(Account ac) throws Exception {
		// TODO Auto-generated method stub
		accountDAO.createAccount(ac);
		
	}

	@Override
	public Account findByUserName(String username) throws Exception {
		// TODO Auto-generated method stub
		Account ac = accountDAO.findAccountByUserName(username);
		
		return ac;
	}

}
