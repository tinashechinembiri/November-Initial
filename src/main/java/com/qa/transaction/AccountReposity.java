package com.qa.transaction;

import java.util.List;

import com.qa.starter.Account;

public interface AccountReposity  {
 List<Account> findallaccounts ();
	
String  AccountCreate (String account_details);
//String makeAccount (String account_name);
Account findaccount (Long id );
Account  AccountUpdate (Account account_details , Long id); 
void  AccountRemove (Long id); 
	
	

}
