package com.co.redtutores.rest_api.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.redtutores.rest_api.commons.entities.Account;
import com.co.redtutores.rest_api.logic.IAccountLogic;
/**
 * 
 * @author kevin david
 *
 */
@Component
public class AccountDelegate implements IAccountDelegate{
	@Autowired
	private IAccountLogic accountLogic;

	@Override
	public void createAccount(Account ac) throws Exception {
		// TODO Auto-generated method stub
		accountLogic.createAccount(ac);
	}

	@Override
	public Account findByUserName(String username) throws Exception {
		// TODO Auto-generated method stub
		Account ac = accountLogic.findByUserName(username);
		return ac;
	}

}
