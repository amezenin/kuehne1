package com.example.kuehne.repository;

import com.example.kuehne.entity.OrderFinale;

import java.util.List;

public interface OrderFinaleCustomRepository {

    List<OrderFinale> findAllByProductCode (String code);
}
