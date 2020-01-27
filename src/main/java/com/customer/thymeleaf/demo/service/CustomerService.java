package com.customer.thymeleaf.demo.service;

import com.customer.thymeleaf.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();
    public Customer findById(int cid);
    public void save(Customer customer);
    public void deleteById(int cid);

}
