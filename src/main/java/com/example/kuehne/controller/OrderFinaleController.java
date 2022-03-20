package com.example.kuehne.controller;

import com.example.kuehne.entity.Customer;
import com.example.kuehne.entity.OrderFinale;
import com.example.kuehne.repository.OrderFinaleRepository;
import com.example.kuehne.service.OrderFinaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderFinaleController {

    @Autowired
    private OrderFinaleService orderFinaleService;


    //tested with Unit test
    @PostMapping("/orders")
    public OrderFinale saveOrderFinale(@RequestBody OrderFinale orderFinale){
        return orderFinaleService.saveOrderFinale(orderFinale);

    }

    @GetMapping("/orders")
    public List<OrderFinale> fetchOrderFinaleList(){
        return orderFinaleService.fetchOrderFinaleList();
    }

    @GetMapping("/orders/{id}")
    public OrderFinale fetchOrderFinaleById(@PathVariable("id") Long id) {
        return orderFinaleService.fetchOrderFinaleById(id);
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrderFinaleById(@PathVariable("id") Long id){
        orderFinaleService.deleteOrderFinaleById(id);
        return "Deleted";
    }

    @PutMapping("/orders/{id}")
    public OrderFinale updateOrderFinale(@PathVariable("id") Long id,
                                 @RequestBody OrderFinale orderFinale){
        return orderFinaleService.updateOrderFinale(id, orderFinale);
    }

    @GetMapping("/orders/name/{name}")
    public List<OrderFinale> findAllByCustomer_FullName(@PathVariable("name") String name){

        return orderFinaleService.findAllByCustomer_FullName(name);

    }

    @GetMapping("/orders/product/{name}")
    public List<OrderFinale> findAllByProductName(@PathVariable("name") String name){

        return orderFinaleService.findAllByProductName(name);

    }


}
