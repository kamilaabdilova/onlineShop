package com.example.onlineshop.entity;



import lombok.*;

import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "ord")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    BigDecimal totalPrice;
    String address;
    LocalDate date;
    String phone;
    Boolean payment;
    @ManyToMany
    List<Product> productList;
    @PrimaryKeyJoinColumn
    @OneToOne
    User user;

}
