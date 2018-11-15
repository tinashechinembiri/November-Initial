package com.qa.business;


import javax.inject.Inject;

import com.qa.starter.Account;
import com.qa.transaction.AccountReposity;

public class Business  implements BusinessService {
	
	
@Inject 
private AccountReposity account ; 


public String findallaccounts()
{
	
	return account.findallaccounts(); 
	
}
public String AccountCreate (String account_details)
{
	return account.AccountCreate(account_details); 
}

public Account findaccount (Long id )
{
	return account.findaccount(id); 
}
public String  AccountUpdate (String account_details , Long id)
{
	return account.AccountUpdate(account_details, id); 
}
public String AccountRemove(Long id)
{
	return account.AccountRemove(id);
}




}
