package com.co.redtutores.rest_api.persistence;

import com.co.redtutores.rest_api.commons.entities.Account;

public interface IAccountDAO {
	
	
	public void createAccount(Account ac) throws Exception;
	
	public Account findAccountByUserName(String username) throws Exception;

}
