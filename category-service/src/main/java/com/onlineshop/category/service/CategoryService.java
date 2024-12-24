package com.onlineshop.category.service;

import com.onlineshop.category.dto.CategoryDTO;
import com.onlineshop.category.entity.Category;
import com.onlineshop.category.entity.Product;
import com.onlineshop.category.repository.CategoryRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final int THRESHOLD_VALUE = 5;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getCategoryWithProducts(String categoryName) {

        if (StringUtils.isNotBlank(categoryName)) {
            Category category = categoryRepository.findByName(categoryName);
            if (category == null) {
                throw new RuntimeException("Category not found");
            }
            else {
                return Collections.singletonList(CategoryDTO.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .description(category.getDescription())
                        .products(category.getCategoryProducts())
                        .build());
            }
        } else {
            List<Category> categories = categoryRepository.findAll();

            return categories.stream()
                    .filter(category -> Objects.nonNull(category.getCategoryProducts()) && category.getCategoryProducts().size() > THRESHOLD_VALUE)
                    .map(category -> {

                        List<Product> categoryProducts = category.getCategoryProducts();

                        List<Product> availableProducts = categoryProducts.stream().filter(product -> product.getInventory().getAvailable() > 0)
                                .collect(Collectors.toList());


                        return CategoryDTO.builder()
                            .id(category.getId())
                            .name(category.getName())
                            .description(CollectionUtils.isEmpty(availableProducts) ? "This category has not sufficient products" :
                                    category.getDescription())
                            .products(category.getCategoryProducts())
                            .build();
                    })
                    .collect(Collectors.toList());
        }
    }
}

