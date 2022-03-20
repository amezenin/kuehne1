package com.example.kuehne.service;

import com.example.kuehne.entity.OrderFinale;
import com.example.kuehne.repository.OrderFinaleCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface OrderFinaleService  {
    OrderFinale saveOrderFinale(OrderFinale orderFinale);

    List<OrderFinale> fetchOrderFinaleList();

    OrderFinale fetchOrderFinaleById(Long id);

    void deleteOrderFinaleById(Long id);

    OrderFinale updateOrderFinale(Long id, OrderFinale orderFinale);

    List<OrderFinale> findAllByCustomer_FullName(String name);

    public List<OrderFinale> findAllByProductName (String name);

    List<OrderFinale> findAllByProductCode (String code);



}
