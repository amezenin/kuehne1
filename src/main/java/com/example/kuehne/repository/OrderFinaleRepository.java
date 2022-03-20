package com.example.kuehne.repository;

import com.example.kuehne.entity.OrderFinale;
import com.example.kuehne.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface OrderFinaleRepository extends JpaRepository<OrderFinale, Long>{

    //tested with Unit Test
    List<OrderFinale> findAllByCreateDate(LocalDate createDate);

    //tested with Unit Test
    @Query("SELECT u FROM OrderFinale u WHERE u.customer.id = ?1")
    List<OrderFinale> findAllByCustomer_Id(Long id);

    List<OrderFinale> findAllByCustomer_FullName(String name);

    @Query("SELECT u FROM OrderFinale u JOIN u.orderLines p WHERE p.product.name = :name")
    List<OrderFinale> findAllByProductName (String name);


}
