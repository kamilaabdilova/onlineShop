package com.example.onlineshop.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)


public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
//    @Column(name = "user")
    @PrimaryKeyJoinColumn
    User user;
    @Column(name = "productList")
    @OneToMany
    List<Product> productList;
    @OneToOne
//    @Column(name = "order")
    @PrimaryKeyJoinColumn
    Order order;
}
