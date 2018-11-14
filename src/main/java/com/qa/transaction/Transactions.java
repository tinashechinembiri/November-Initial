package com.qa.transaction;

import java.util.List;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.starter.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class Transactions {

	@PersistenceContext(unitName ="primary")
	private EntityManager manager; 
	
	public List<Account> findallaccounts ()
	{
		TypedQuery<Account>  query = manager.createQuery("SELECT i FROM Account m ORDER BY m.Account_number DESC", Account.class);
		
		return query.getResultList(); 
	}
	
	 
	public String makeAccount (String account_name)
	{
		Account aaccount = JSONUtil.getObjectForJSON(account_name,Account.class );
		manager.persist(aaccount);
		return "{\"message\":\"account added\"}"; 
		
		
	}
	
	public Account findaccount (Long id )
	{
		return manager.find(Account.class, id); 
	}
	
	@Transactional(REQUIRED)
	public Account  AccountCreate (Account account_details)
	{
		manager.persist(account_details);
		return account_details; 
	}
	public Account  AccountUpdate (Account account_details , Long id)
	{
		
		Account a = findaccount(id);
		a.setAccount_number(account_details.getAccount_number());
		a.setFirstName(account_details.getFirstName());
		a.setSecondName(account_details.getSecondName());
		manager.merge(a);
		return a; 
	}
	public void AccountRemove (Account account_delete)
	{
		manager.remove(account_delete);
		//return account_delete; 
	}
	
	
}
