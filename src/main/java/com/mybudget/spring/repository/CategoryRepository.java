package com.mybudget.spring.repository;

import com.mybudget.spring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> getCategoryByName(String name);
}
