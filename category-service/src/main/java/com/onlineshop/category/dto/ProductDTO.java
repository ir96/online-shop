package com.onlineshop.category.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private String id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private int availableInventory;
    private Map<String, String> attributes;
}
