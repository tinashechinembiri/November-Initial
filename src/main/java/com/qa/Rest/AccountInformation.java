package com.qa.Rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.BusinessService;

@Path("/account")
public class AccountInformation {
	@Inject 
	private BusinessService business; 
	
	@Path ("/json")
	@GET
	@Produces({"application/json"})
	public String findallaccounts ()
	{
		return business.findallaccounts();
	}
	
	@Path("/json")
	@POST
	@Produces({"application/json"})
	public String AccountCreate(String account_details)
	{
		return business.AccountCreate(account_details); 
	}
	@Path ("/json/{id}")
	@PUT
	@Produces({"application/json"})
	public String AccountUpdate(@PathParam("id") Long id, String account )
	{
		return business.AccountUpdate(account, id); 
	}
	
	
	

}
