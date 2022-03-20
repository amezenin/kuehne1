package com.example.kuehne.controller;

import com.example.kuehne.entity.Customer;
import com.example.kuehne.error.CustomerNotFoundException;
import com.example.kuehne.repository.CustomerRepository;
import com.example.kuehne.service.CustomerService;
import com.example.kuehne.service.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    //tested with Unit test and postman
    @PostMapping("/customers")
    public Customer saveCustomer(@Valid @RequestBody Customer customer){
        logger.info("Inside saveCustomer of CustomerController");
        return customerService.saveCustomer(customer);

    }

    //tested with postman
    @GetMapping("/customers")
    public List<Customer> fetchCustomerList(){
        logger.info("Inside fetchCustomerList of CustomerController");
        return customerService.fetchCustomerList();
    }

    //tested with Unit test and postman
    @GetMapping("/customers/{id}")
    public Customer fetchCustomerById(@PathVariable("id") Long id) throws CustomerNotFoundException {
        return customerService.fetchCustomerById(id);
    }

    //tested with postman
    @DeleteMapping("/customers/{id}")
    public String deleteCustomerById(@PathVariable("id") Long id){
        customerService.deleteCustomerById(id);
        return "Deleted";
    }

    //tested with postman
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable("id") Long id,
                                   @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    //search in link postman
    @GetMapping("/customers/name/{name}")
    public Customer fetchCustomerByName(@PathVariable("name") String customerName) {
        return customerService.fetchCustomerByName(customerName);
    }

    @GetMapping("/customers/name/{name}/{code}")
    public List<Customer> findByNameAndCode(@PathVariable("name") String fullName,
                                                   @PathVariable("code") String regCode){

        return customerService.findByNameAndCode(fullName, regCode);

    }
}
