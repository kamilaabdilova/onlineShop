package com.example.onlineshop.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String type;
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "image")
    private byte[] image;
}
