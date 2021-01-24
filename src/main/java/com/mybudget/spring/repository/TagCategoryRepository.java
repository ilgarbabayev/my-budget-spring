package com.mybudget.spring.repository;

import com.mybudget.spring.model.TagCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagCategoryRepository extends JpaRepository<TagCategory, Long> {
}
