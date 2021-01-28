package com.mybudget.spring.controller;

import com.mybudget.spring.model.Category;
import com.mybudget.spring.service.Impl.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    @GetMapping("/{all}")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/{name}")
    public Category getCategory(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }
}
