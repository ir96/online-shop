package com.onlineshop.category.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;

    @Column(length = 1000)
    private String description;

    @Embedded
    private Price price;

    @Embedded
    private Inventory inventory;

    @ElementCollection
    private List<Attribute> attributes;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="id", nullable=false)
    private Category category;
}

