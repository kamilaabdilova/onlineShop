package com.example.onlineshop.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

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
    @Column(name = "totalPrice")
    Double totalPrice;
    @OneToOne
    @PrimaryKeyJoinColumn
    Basket basket;
    @PrimaryKeyJoinColumn
    @OneToOne
    User user;

}
