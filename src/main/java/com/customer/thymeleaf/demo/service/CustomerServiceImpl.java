package com.customer.thymeleaf.demo.service;

import com.customer.thymeleaf.demo.dao.CustomerRepository;
import com.customer.thymeleaf.demo.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;



    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int cid) {
        Optional<Customer> result = customerRepository.findById(cid);

        Customer customer = null;

        if (result.isPresent()) {
            customer = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + cid);
        }

        return customer;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(int cid) {
        customerRepository.deleteById(cid);
    }
}
