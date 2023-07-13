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
@Table(name = "use")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "email", unique = true)
    String email;
    @Column(name = "password")
    String password;
    @OneToOne
    @PrimaryKeyJoinColumn
    Basket basket;
    @OneToOne
    @PrimaryKeyJoinColumn
    Order order;
}
