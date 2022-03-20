package com.example.kuehne.service;

import com.example.kuehne.entity.OrderLine;
import com.example.kuehne.repository.OrderFinaleRepository;
import com.example.kuehne.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderLineService {

    OrderLine saveOrderLine(OrderLine orderLine);

    List<OrderLine> fetchOrderLineList();

    OrderLine fetchOrderLineById(Long id);

    void deleteOrderLineById(Long id);

    OrderLine updateOrderLine(Long id, OrderLine orderLine);
}
