package com.onlineshop.product.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Embedded;
import javax.persistence.Embeddable;
import javax.persistence.ElementCollection;
import javax.persistence.GenerationType;
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
}

@Embeddable
@Data
class Price {
    private String currency;
    private BigDecimal amount;
}

@Embeddable
@Data
class Inventory {
    private int total;
    private int available;
    private int reserved;
}

@Embeddable
@Data
class Attribute {
    private String name;
    private String value;
}
