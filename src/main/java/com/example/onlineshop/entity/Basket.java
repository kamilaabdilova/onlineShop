package com.example.onlineshop.entity;



import lombok.*;

import lombok.experimental.FieldDefaults;

import javax.persistence.*;
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

    @PrimaryKeyJoinColumn

    User user;
    @Column(name = "productList")
    @OneToMany
    List<Product> productList;
    @OneToOne
    @PrimaryKeyJoinColumn
    Order order;
}
