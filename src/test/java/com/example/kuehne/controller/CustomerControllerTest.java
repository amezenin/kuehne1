package com.example.kuehne.controller;

import com.example.kuehne.entity.Customer;
import com.example.kuehne.error.CustomerNotFoundException;
import com.example.kuehne.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = Customer.builder()
                .fullName("Kira")
                .regCode("df")
                .email("df")
                .telephone("34")
                .id(1L)
                .build();
    }

    @Test
    void saveCustomer() throws Exception {
        Customer inputCustomer = Customer.builder()
                .fullName("Kira")
                .regCode("df")
                .email("df")
                .telephone("34")
                .build();

        Mockito.when(customerService.saveCustomer(inputCustomer)).thenReturn(customer);

        mockMvc.perform(MockMvcRequestBuilders.post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{   \n" +
                        "\"fullName\": \"Kira\",\n" +
                        "\"regCode\": \"df\",\n" +
                        "\"email\": \"df\",\n" +
                        "\"telephone\": \"34\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchCustomerById() throws Exception {
        Mockito.when(customerService.fetchCustomerById(1L)).thenReturn(customer);

        mockMvc.perform(MockMvcRequestBuilders.get("/customers/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.fullName")
                        .value(customer.getFullName()));

    }
}