package com.example.kuehne.controller;

import com.example.kuehne.entity.OrderLine;
import com.example.kuehne.entity.Product;
import com.example.kuehne.service.OrderLineService;
import com.example.kuehne.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderLineController {

    @Autowired
    private OrderLineService orderLineService;

    //tested with Unit test and postman
    @PostMapping("/orderlines")
    public OrderLine saveOrderLine(@RequestBody OrderLine orderLine){
        return orderLineService.saveOrderLine(orderLine);

    }

    //tested with postman
    @GetMapping("/orderlines")
    public List<OrderLine> fetchOrderLineList(){
        return orderLineService.fetchOrderLineList();
    }

    //tested with  postman
    @GetMapping("/orderlines/{id}")
    public OrderLine fetchOrderLineById(@PathVariable("id") Long id) {
        return orderLineService.fetchOrderLineById(id);
    }

    //tested with postman
    @DeleteMapping("/orderlines/{id}")
    public String deleteOrderLineById(@PathVariable("id") Long id){
        orderLineService.deleteOrderLineById(id);
        return "Deleted";
    }

    //tested by Unit test and postman
    @PutMapping("/orderlines/{id}")
    public OrderLine updateOrderLine(@PathVariable("id") Long id,
                                 @RequestBody OrderLine orderLine){
        return orderLineService.updateOrderLine(id, orderLine);
    }
}
