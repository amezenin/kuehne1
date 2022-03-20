package com.example.kuehne.service;

import com.example.kuehne.entity.Customer;
import com.example.kuehne.entity.OrderFinale;
import com.example.kuehne.entity.OrderLine;
import com.example.kuehne.entity.Product;
import com.example.kuehne.repository.OrderFinaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

@Service
public class OrderFinaleServiceImpl implements OrderFinaleService {

    @Autowired
    private OrderFinaleRepository orderFinaleRepository;

    @Override
    public OrderFinale saveOrderFinale(OrderFinale orderFinale) {
        return orderFinaleRepository.save(orderFinale);
    }

    @Override
    public List<OrderFinale> fetchOrderFinaleList() {
        return orderFinaleRepository.findAll();
    }

    @Override
    public OrderFinale fetchOrderFinaleById(Long id) {
        return orderFinaleRepository.findById(id).get();
    }

    @Override
    public void deleteOrderFinaleById(Long id) {
        orderFinaleRepository.deleteById(id);

    }

    @Override
    public OrderFinale updateOrderFinale(Long id, OrderFinale orderFinale) {
        OrderFinale orderFinaleDB = orderFinaleRepository.findById(id).get();

        if(Objects.nonNull(orderFinale.getCreateDate())){
            orderFinaleDB.setCreateDate(orderFinale.getCreateDate());
        }

        return orderFinaleRepository.save(orderFinaleDB);
    }

    @Override
    public List<OrderFinale> findAllByCustomer_FullName(String name) {
        return orderFinaleRepository.findAllByCustomer_FullName(name);
    }

    @Override
    public List<OrderFinale> findAllByProductName (String name){
        return orderFinaleRepository.findAllByProductName(name);
    }

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<OrderFinale> findAllByProductCode(String code) {

        return orderFinaleRepository.findAllByProductCode(code);

    }


}
