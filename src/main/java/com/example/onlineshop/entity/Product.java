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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "price", nullable = false)
    Double price;
    @Column(name = "image")
    String image;
    @Column(name = "description")
    String description;
    @OneToOne()
    @PrimaryKeyJoinColumn
    Status status;

}
