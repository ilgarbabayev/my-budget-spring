package com.mybudget.spring.service.Impl;

import com.mybudget.spring.Exception.CategoryNotFoundException;
import com.mybudget.spring.model.Category;
import com.mybudget.spring.repository.CategoryRepository;
import com.mybudget.spring.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id.toString()));
    }

    @Override
    @Transactional(readOnly = true)
    public Category getCategoryByName(String name) {
        return categoryRepository.getCategoryByName(name).orElseThrow(() -> new CategoryNotFoundException(name));
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }
}
