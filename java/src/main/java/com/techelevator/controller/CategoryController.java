package com.techelevator.controller;

import com.techelevator.entity.Category;
import com.techelevator.exception.ApiException;
import com.techelevator.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category newCategory) throws ApiException {
        return categoryService.addCategory(newCategory);
    }
}
