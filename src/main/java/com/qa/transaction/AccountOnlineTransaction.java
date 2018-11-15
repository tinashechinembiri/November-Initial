package com.qa.transaction;

import java.util.HashMap;

import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.qa.starter.Account;
import com.qa.util.JSONUtil;
@ApplicationScoped
@Alternative 
public class AccountOnlineTransaction implements AccountReposity{
	@Inject
	JSONUtil util; 
	
	private final Long INITIAL_COUNT = 1L; 
	private Map <Long, Account> accountDetails;
	@PersistenceContext(unitName ="primary")
	private EntityManager manager; 
	private Long ID; 
	
	 AccountOnlineTransaction(){
		this.accountDetails = new HashMap <Long,Account>(); 
		ID = INITIAL_COUNT; 
	 }
	
	@Override
	public String findallaccounts()
	{
		return util.getJSONForObject(accountDetails.values()); 
	}

	@Override
	public String AccountCreate(String account_details) {
		ID++; 
		Account make_account = JSONUtil.getObjectForJSON(account_details, Account.class);
		accountDetails.put(ID, make_account); 
		return account_details;
	}

	@Override
	public Account findaccount(Long id) {
		
		return manager.find(Account.class, id); 
	}

	@Override
	public String AccountUpdate(String account_details, Long id) {
		Account a = JSONUtil.getObjectForJSON(account_details, Account.class); 
		accountDetails.put(id, a);
		return account_details ; 
	}

	@Override
	public String AccountRemove(Long id) {
		accountDetails.remove(id); 
		return "{\"message\":}\"succesfully removed\""; 
		
	}
	
	
	
	
	

}
