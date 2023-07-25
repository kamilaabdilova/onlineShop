package com.example.onlineshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    Image image;
    @Column(name = "description")
    String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    Status status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    Category category;

}
