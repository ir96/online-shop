package com.onlineshop.category.controller;

import com.onlineshop.category.dto.CategoryDTO;
import com.onlineshop.category.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(summary = "Get All Categories With Product",
            description = "Fetch all products within a category with sufficient inventory")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved products"),
            @ApiResponse(responseCode = "400", description = "Invalid category or insufficient inventory"),
    })
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategoriesWithProduct(@RequestParam(required = false) String name) {
        return ResponseEntity.ok(categoryService.getCategoryWithProducts(name));
    }
}

