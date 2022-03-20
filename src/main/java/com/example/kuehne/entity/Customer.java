package com.example.kuehne.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please add name")
    private String fullName;
    @NotBlank(message = "Please add registration code")
    private String regCode;
    @NotBlank(message = "Please add email")
    private String email;
    @NotBlank(message = "Please add telephone")
    private String telephone;

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<OrderFinale> orderFinale;


}
