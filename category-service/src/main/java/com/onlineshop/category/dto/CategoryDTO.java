package com.onlineshop.category.dto;

import com.onlineshop.category.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
    private List<Product> products;
}