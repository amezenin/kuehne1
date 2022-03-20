package com.example.kuehne.service;

import com.example.kuehne.entity.OrderFinale;
import com.example.kuehne.entity.OrderLine;
import com.example.kuehne.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Override
    public OrderLine saveOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    @Override
    public List<OrderLine> fetchOrderLineList() {
        return orderLineRepository.findAll();
    }

    @Override
    public OrderLine fetchOrderLineById(Long id) {
        return orderLineRepository.findById(id).get();
    }

    @Override
    public void deleteOrderLineById(Long id) {
        orderLineRepository.deleteById(id);

    }

    @Override
    public OrderLine updateOrderLine(Long id, OrderLine orderLine) {

        OrderLine orderLineDB = orderLineRepository.findById(id).get();

        if(Objects.nonNull(orderLine.getQuantity())){
            orderLineDB.setQuantity(orderLine.getQuantity());
        }

        return orderLineRepository.save(orderLineDB);
    }
}
