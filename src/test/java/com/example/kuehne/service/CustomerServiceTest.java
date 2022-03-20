package com.example.kuehne.service;

import com.example.kuehne.entity.Customer;
import com.example.kuehne.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        Customer customer = Customer.builder()
                .fullName("Anton")
                .regCode("ddd")
                .email("email")
                .telephone("444")
                .id(1L)
                .build();

        Mockito.when(customerRepository.findByFullNameIgnoreCase("Anton")).thenReturn(customer);
    }

    @Test
    @DisplayName("Get data based on Customer Name")
    public void whenValidCustomerNameThenCustomerShouldFound(){

        String customerName = "Anton";
        Customer found = customerService.fetchCustomerByName(customerName);
        assertEquals(customerName, found.getFullName());

    }
}