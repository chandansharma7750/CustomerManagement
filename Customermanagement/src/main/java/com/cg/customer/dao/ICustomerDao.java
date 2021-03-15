package com.cg.customer.dao;

import com.cg.customer.entities.Customer;

public interface ICustomerDao {
	Customer add(Customer customer);
    Customer findByID(Long customerID);
    Customer update(Customer customer);

}
