package com.qa.transaction;

import java.util.Collection;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.transaction.Transactional;

import com.qa.starter.Account;
import com.qa.util.JSONUtil;
@Default

@Transactional(SUPPORTS)
public class Transactions implements AccountReposity {
	@Inject
	JSONUtil util; 
	@PersistenceContext(unitName ="primary")
	private EntityManager manager; 
	
	public String findallaccounts ()
	{
		Query  check = manager.createQuery("SELECT a FROM Account a");
		Collection <Account>  query = (Collection<Account>) check.getResultList(); 
		 return util.getJSONForObject(query); 
	}
	
	 
	
	
	public Account findaccount (Long id )
	{
		return manager.find(Account.class, id); 
	}
	
	@Transactional(REQUIRED)
	public String  AccountCreate (String account_details)
	{
		Account create_Account = JSONUtil.getObjectForJSON(account_details, Account.class); 
		manager.persist(create_Account);
		return account_details; 
	}
	@Transactional(REQUIRED)
	public String  AccountUpdate (String account_details , Long id)
	{
		Account updateaccount  = JSONUtil.getObjectForJSON(account_details, Account.class); 
		Account a = findaccount(id);
		//a.setAccount_number(account_details.getAccount_number());
		//a.setFirstName(account_details.getFirstName());
		//a.setSecondName(account_details.getSecondName());
		if (account_details !=null)
		{
			a = updateaccount; 
			manager.merge(a);
		}
		
		return account_details ; 
	}
	@Transactional(REQUIRED)
	public String AccountRemove (Long id)
	{
		Account account_delete = findaccount(id);
		if (account_delete != null)
		{
		
		manager.remove(account_delete);
		}
		return "{\\\"message\\\":}\\\"succesfully removed\\\"";
	}


	
	
	
}
