package com.onlineshop.category.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Inventory {
    private int total;
    private int available;
    private int reserved;
}
