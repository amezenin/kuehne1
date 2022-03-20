package com.example.kuehne.service;

import com.example.kuehne.entity.Customer;
import com.example.kuehne.error.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);

    public List<Customer> fetchCustomerList();

    public Customer fetchCustomerById(Long id) throws CustomerNotFoundException;

    public void deleteCustomerById(Long id);

    public Customer updateCustomer(Long id, Customer customer);

    //tested with Unit test and postman
    Customer fetchCustomerByName(String customerName);

    List<Customer>findByNameAndCode(String fullName, String regCode);
}
