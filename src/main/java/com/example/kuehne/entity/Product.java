package com.example.kuehne.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please add name")
    private String name;

    @NotBlank(message = "Please add code")
    private String skuCode;

    private Integer unitPrice;

    @OneToMany(mappedBy="product", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<OrderLine> orderLine;

}


