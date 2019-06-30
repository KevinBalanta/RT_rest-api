package com.co.redtutores.rest_api.delegate;

import com.co.redtutores.rest_api.commons.entities.Account;

public interface IAccountDelegate {
	
	public void createAccount(Account ac) throws Exception;
	
	public Account findByUserName(String username) throws Exception;

}
