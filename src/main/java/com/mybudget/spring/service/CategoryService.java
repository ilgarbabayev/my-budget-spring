package com.mybudget.spring.service;

import com.mybudget.spring.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Integer id);
    Category getCategoryByName(String name);
    void createCategory(Category category);
}
