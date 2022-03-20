package com.example.kuehne.repository;

import com.example.kuehne.entity.OrderFinale;
import com.example.kuehne.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

    List<OrderLine> findAllByProduct(Long id);
}
