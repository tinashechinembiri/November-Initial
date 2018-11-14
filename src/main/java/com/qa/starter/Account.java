package com.qa.starter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
public class Account {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	@Column (length = 100)
	private String  firstName; 
	@Column (length = 100)
	private String secondName;
	@Column (length = 10)
	private int Account_number; 
	
	
	
	public Account(Long id, String firstName, String secondName, int account_number) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		Account_number = account_number;
	}
	public int getAccount_number() {
		return Account_number;
	}
	public void setAccount_number(int account_number) {
		Account_number = account_number;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", Account_number="
				+ Account_number + "]";
	} 
	
	
	
	
}
