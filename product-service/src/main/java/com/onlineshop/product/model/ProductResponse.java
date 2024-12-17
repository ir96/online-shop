package com.onlineshop.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public
class ProductResponse {
    private Long id;
    private String name;
    private double price;
    private int inventory;
    private Long categoryId;
}
