package com.qa.business;

import com.qa.starter.Account;

public interface BusinessService {
	String findallaccounts ();
		
	 String  AccountCreate (String account_details);
	 //String makeAccount (String account_name);
	 Account findaccount (Long id );
	 String  AccountUpdate (String account_details , Long id); 
	 String  AccountRemove (Long id); 

}
