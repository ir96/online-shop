package com.onlineshop.product.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String brand;
    private String description;
    private PriceDTO price;
    private InventoryDTO inventory;
    private List<AttributeDTO> attributes;
}

@Data
class PriceDTO {
    private String currency;
    private BigDecimal amount;
}

@Data
class InventoryDTO {
    private int total;
    private int available;
    private int reserved;
}

@Data
class AttributeDTO {
    private String name;
    private String value;
}
