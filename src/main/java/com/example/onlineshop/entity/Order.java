package com.example.onlineshop.entity;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    String phone;
    Boolean payment;
    @OneToMany(fetch = FetchType.EAGER)
    List<Product> productList;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    User user;

    public Order(Long id, User user, List<Product> productList) {
        this.id = id;
        this.user = user;
        this.productList = productList;
    }
    public Map<Long, Product> getProductMap() {
        Map<Long, Product> productMap = productList
                .stream()
                .collect(Collectors.toMap(Product::getId, p -> p));
        return productMap;
    }
}
