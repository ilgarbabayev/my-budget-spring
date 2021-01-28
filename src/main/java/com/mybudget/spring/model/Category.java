package com.mybudget.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "type", "parent_category_category_id"})})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @OneToMany(mappedBy = "category")
    private List<Transaction> transaction = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private List<Category> subCategories = new ArrayList<>();

    @Column(name = "icon_name")
    @NotBlank
    private String iconName;

    private boolean enabled;

    public void moveCategory(Category parentCategory){
        this.getParentCategory().getSubCategories().remove(this);
        parentCategory.getSubCategories().add(this);
        this.setParentCategory(parentCategory);
    }

    public void addSubCategory(Category subCategory){
        this.getSubCategories().add(subCategory);
        subCategory.setParentCategory(this);
    }
}
