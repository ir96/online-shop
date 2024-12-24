package com.onlineshop.product.service.external;

import com.onlineshop.product.dto.CategoryDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CATEGORY-SERVICE/category")
public interface CategoryService {

    @GetMapping("/{name}")
    ResponseEntity<CategoryDTO> getCategory(@PathVariable String name);

}
