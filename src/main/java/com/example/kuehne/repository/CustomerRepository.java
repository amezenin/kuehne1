package com.example.kuehne.repository;

import com.example.kuehne.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Customer findByFullName(String fullName);

    //tested with postman
    public Customer findByFullNameIgnoreCase(String fullName);

    List<Customer> findByFullNameAndRegCode(String fullName, String regCode);

}
