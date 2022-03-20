package com.example.kuehne.specifications;

import com.example.kuehne.entity.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class OrderFinaleSpecification {

    public static Specification<OrderFinale> hasCode(String code){
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.join(OrderFinale_.ORDER_LINES).join(OrderLine_.PRODUCT).get(Product_.SKU_CODE),code);
        });
    }

}
