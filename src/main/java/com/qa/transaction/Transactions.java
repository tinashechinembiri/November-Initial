package com.qa.transaction;

import java.util.List;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.starter.Account;
import com.qa.util.JSONUtil;
@Default

@Transactional(SUPPORTS)
public class Transactions implements AccountReposity {

	@PersistenceContext(unitName ="primary")
	private EntityManager manager; 
	
	public List<Account> findallaccounts ()
	{
		TypedQuery<Account>  query = manager.createQuery("SELECT i FROM Account m ORDER BY m.Account_number DESC", Account.class);
		
		return query.getResultList(); 
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
	public Account  AccountUpdate (Account account_details , Long id)
	{
		
		Account a = findaccount(id);
		a.setAccount_number(account_details.getAccount_number());
		a.setFirstName(account_details.getFirstName());
		a.setSecondName(account_details.getSecondName());
		manager.merge(a);
		return a; 
	}
	@Transactional(REQUIRED)
	public void AccountRemove (Long id)
	{
		Account account_delete = findaccount(id);
		if (account_delete != null)
		{
		
		manager.remove(account_delete);
		}
	}


	
	
	
}
