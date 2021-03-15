package com.cg.customer.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.customer.dao.ICustomerDao;
import com.cg.customer.entities.Account;
import com.cg.customer.entities.Customer;

@Service
public class ICustomerImpl implements ICustomerService {
	@Autowired
	private ICustomerDao dao;
	
	@Transactional
	@Override
	public Customer createCustomer(String name) {
		Account account = new Account();
		Customer customer=new Customer(name,account);
		dao.add(customer);
		return customer;
	}
	
	@Override
	public Customer findByID(Long customerID) {
		Customer customer = dao.findByID(customerID);
		return customer;
		}
	
	@Transactional
	@Override
	public Customer addAmount(Long customerID, double amount) {
		Customer customer = dao.findByID(customerID);
		customer.getAccount().setBalance(amount);
		dao.update(customer);
		return customer;
	}

}
