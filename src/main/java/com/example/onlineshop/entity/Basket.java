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
    @Column(name = "user_id")
    Long id;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    User user;
    @OneToMany(fetch = FetchType.EAGER)
    List<Product> productList;
}
