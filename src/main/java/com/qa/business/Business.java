package com.qa.business;
import java.util.List;

import javax.inject.Inject;

import com.qa.starter.Account;
import com.qa.transaction.AccountReposity;

public class Business  implements BusinessService {
	
	
@Inject 
private AccountReposity account ; 


public List<Account> findallaccounts()
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
public Account AccountUpdate (Account account_details , Long id)
{
	return account.AccountUpdate(account_details, id); 
}
public void AccountRemove(Long id)
{
	account.AccountRemove(id);
}




}
