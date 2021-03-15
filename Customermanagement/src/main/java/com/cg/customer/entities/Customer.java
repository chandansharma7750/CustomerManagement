package com.cg.customer.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Customer {  
	@Id
	@GeneratedValue
	private long id; //primary key
	private String name;
	private Account account;
	public Customer(String name, Account account) {
		this.name=name;
		this.account=account;
		//
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setAccount(Account account) {
		this.account=account;
	}
	public Account getAccount() {
		return account;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

	
	
	

}
