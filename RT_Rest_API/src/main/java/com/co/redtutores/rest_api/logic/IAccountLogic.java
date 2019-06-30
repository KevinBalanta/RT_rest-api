package com.co.redtutores.rest_api.logic;

import com.co.redtutores.rest_api.commons.entities.Account;

public interface IAccountLogic {
	
	public void createAccount(Account ac) throws Exception;
	
	public Account findByUserName(String username) throws Exception;

}
