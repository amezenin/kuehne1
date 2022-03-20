package com.example.kuehne.repository;

import com.example.kuehne.entity.OrderFinale;
import com.example.kuehne.entity.OrderLine;
import com.example.kuehne.entity.Product;
import com.example.kuehne.entity.Product_;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;

public class OrderFinaleCustomRepositoryImpl implements OrderFinaleCustomRepository {

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<OrderFinale> findAllByProductCode(String code) {

        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery cq=cb.createQuery(OrderFinale.class);

        Root<OrderFinale> orderFinaleRoot=cq.from(OrderFinale.class);

        Join<OrderFinale, OrderLine> orderLine= orderFinaleRoot.join("orderLines");

        Join<OrderLine, Product> productJoin= orderLine.join("product");

        cq.where(cb.equal(productJoin.get(Product_.SKU_CODE), code));

        TypedQuery<OrderFinale> query=entityManager.createQuery(cq);

        return query.getResultList();

    }
}
