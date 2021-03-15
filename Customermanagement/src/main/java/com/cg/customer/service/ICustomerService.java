package com.cg.customer.service;

import com.cg.customer.entities.Customer;

public interface ICustomerService {

	Customer findByID(Long customerID);
    Customer createCustomer(String name); 
    Customer addAmount(Long customerId, double amount);
}
