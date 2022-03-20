package com.example.kuehne.repository;

import com.example.kuehne.entity.Customer;
import com.example.kuehne.entity.OrderFinale;
import com.example.kuehne.entity.OrderLine;
import com.example.kuehne.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
        /*Annotations for testing in local DB*/
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
class OrderLineRepositoryTest {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private TestEntityManager entityManager;

    //in memory
    @BeforeEach
    void setUp() {
        Product product =
                Product.builder()
                        .name("Gold")
                        .skuCode("gold4")
                        .unitPrice(666)
                        .build();
        entityManager.persist(product);

        OrderLine orderLine =
                OrderLine.builder()
                        .quantity(5)
                        .product(product)
                        .build();

        entityManager.persist(orderLine);
    }

    //db test
    @Test
    public void testEditQuantityInOrderLine() {

        OrderLine orderLine = entityManager.find(OrderLine.class, 5L);

        orderLine.setQuantity(20);

        OrderLine savedOrderLine = orderLineRepository.save(orderLine);

        assertThat(savedOrderLine.getQuantity()).isEqualTo(20);
    }

    //in memory
    @Test
    public void whenFindByIdOrderLine_thenReturnOrderLineAndFetchProductName() {

        OrderLine orderLine = orderLineRepository.findById(2L).get();
        assertEquals(orderLine.getProduct().getName(), "Gold");

    }

    //edit in memory
    @Test
    public void testEditQuantityInOrderLineInMemory() {

        OrderLine orderLine = orderLineRepository.findById(2L).get();

        //orderLine.setQuantity(20);

        OrderLine savedOrderLine = orderLineRepository.save(orderLine);

        assertThat(savedOrderLine.getQuantity()).isEqualTo(20);
    }


}