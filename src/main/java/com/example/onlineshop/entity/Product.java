package com.example.onlineshop.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

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
    BigDecimal price;
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    Brand brand;

}
