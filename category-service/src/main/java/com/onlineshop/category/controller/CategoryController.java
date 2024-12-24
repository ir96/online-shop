package com.onlineshop.category.controller;

import com.onlineshop.category.dto.CategoryDTO;
import com.onlineshop.category.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategoriesWithProduct(@RequestParam(required = false) String name) {
        return ResponseEntity.ok(categoryService.getCategoryWithProducts(name));
    }
}

