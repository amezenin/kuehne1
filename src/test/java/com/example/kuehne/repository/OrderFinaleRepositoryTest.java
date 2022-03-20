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


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
        /*for db testing*/
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class OrderFinaleRepositoryTest {

    @Autowired
    private OrderFinaleRepository orderFinaleRepository;

    @Autowired
    private TestEntityManager entityManager;

   /* @BeforeEach
    void setUp() {
        Customer customer =
                Customer.builder()
                        .fullName("Evgen")
                        .regCode("df")
                        .email("e")
                        .telephone("33")
                        .build();

        entityManager.persist(customer);

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

        OrderLine orderLine2 =
                OrderLine.builder()
                        .quantity(10)
                        .product(product)
                        .build();
        entityManager.persist(orderLine2);

        List<OrderLine> orderLines = new ArrayList<OrderLine>();

        orderLines.add(orderLine);
        orderLines.add(orderLine2);

        OrderFinale orderFinale =
                OrderFinale.builder()
                        .createDate(LocalDate.now())
                        .customer(customer)
                        .orderLines(orderLines)
                        .build();
        entityManager.persist(orderFinale);
    }*/

    //MyDB test
    @Test
    public void testAddOneOrderWithCustomer() {
        Customer customer = entityManager.find(Customer.class, 1L);

        OrderFinale orderFinale = new OrderFinale();
        orderFinale.setCustomer(customer);

        OrderFinale saveOrderFinale = orderFinaleRepository.save(orderFinale);

        assertTrue(saveOrderFinale.getId() > 0);

    }

    //MyDB test
    @Test
    public void whenFindAllByCreateDate_thenOrdersReturnList() {
        LocalDate date = LocalDate.parse("2022-03-16");
        List<OrderFinale> result = orderFinaleRepository.findAllByCreateDate(date);

        assertEquals(5, result.size());

    }

    //MyDB test
    @Test
    public void whenfindAllOrdersByCustomerId_thenReturnListWithCorrectIds() {
        List<OrderFinale> result = orderFinaleRepository.findAllByCustomer_Id(1L);

        assertThat(result)
                .extracting(OrderFinale::getId)
                .containsExactlyInAnyOrder(2L, 4L, 10L, 11L, 14L);

    }

    //MyDB test
    @Test
    public void whenCustomerDontHaveOrders_thenReturnEmptyList() {
        List<OrderFinale> result = orderFinaleRepository.findAllByCustomer_Id(12L);

        assertEquals(0, result.size());

    }

    //MyDB test
    @Test
    public void testAddOneOrderWithCustomerAndOrderLineDB() {
        Customer customer = entityManager.find(Customer.class, 1L);

        Product product = entityManager.find(Product.class, 2l);
        Product product2 = entityManager.find(Product.class, 3l);

        OrderLine orderLine = new OrderLine();
        orderLine.setQuantity(5);
        orderLine.setProduct(product);

        OrderLine orderLine1 = new OrderLine();
        orderLine1.setQuantity(10);
        orderLine1.setProduct(product2);
        List<OrderLine> g = new ArrayList<OrderLine>();
        g.add(orderLine);
        g.add(orderLine1);

        OrderFinale orderFinale = new OrderFinale();
        orderFinale.setOrderLines(g);
        orderFinale.setCustomer(customer);

        OrderFinale saveOrderFinale = orderFinaleRepository.save(orderFinale);

        assertTrue(saveOrderFinale.getId() > 0);

    }

    //MemoryDB test
    @Test
    public void whenFindOrderByCustomer_thenCanFindCustomerName() {

        OrderFinale orderFinale = orderFinaleRepository.findById(5L).get();

        assertSame("Evgen", orderFinale.getCustomer().getFullName());

    }

    //MemoryDB test
    @Test
    public void whenFindOrderByCustomer_thenCanFindProductName() {

        OrderFinale orderFinale = orderFinaleRepository.findById(5L).get();

        assertSame("Gold", orderFinale.getOrderLines().get(1).getProduct().getName());

    }




}