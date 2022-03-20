package com.example.kuehne.repository;

import com.example.kuehne.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Customer customer =
                Customer.builder()
                        .fullName("Evgen")
                        .regCode("df")
                        .email("e")
                        .telephone("33")
                        .build();

        entityManager.persist(customer);
    }

    @Test
    public void whenFindById_thenReturnCustomer() {

        Customer customer = customerRepository.findById(1L).get();
        assertEquals(customer.getFullName(), "Evgen");

    }
}