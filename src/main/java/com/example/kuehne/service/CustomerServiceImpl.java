package com.example.kuehne.service;

import com.example.kuehne.entity.Customer;
import com.example.kuehne.error.CustomerNotFoundException;
import com.example.kuehne.repository.CustomerRepository;
import lombok.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> fetchCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public Customer fetchCustomerById(Long id) throws CustomerNotFoundException {
        //Optional for exception handler
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isEmpty()) {
            throw new CustomerNotFoundException("Customer not available");
        }

        return customer.get();
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer customerDB = customerRepository.findById(id).get();

        if (Objects.nonNull(customer.getFullName()) &&
                !"".equalsIgnoreCase(customer.getFullName())) {
            customerDB.setFullName(customer.getFullName());
        }

        if (Objects.nonNull(customer.getRegCode()) &&
                !"".equalsIgnoreCase(customer.getRegCode())) {
            customerDB.setRegCode(customer.getRegCode());
        }

        if (Objects.nonNull(customer.getEmail()) &&
                !"".equalsIgnoreCase(customer.getEmail())) {
            customerDB.setEmail(customer.getEmail());
        }

        if (Objects.nonNull(customer.getTelephone()) &&
                !"".equalsIgnoreCase(customer.getTelephone())) {
            customerDB.setTelephone(customer.getTelephone());
        }

        return customerRepository.save(customerDB);

    }

    //tested with Unit test
    @Override
    public Customer fetchCustomerByName(String customerName) {
        return customerRepository.findByFullNameIgnoreCase(customerName);
    }

    @Override
    public List<Customer> findByNameAndCode(String fullName, String regCode) {
        return customerRepository.findByFullNameAndRegCode(fullName, regCode);
    }


}
