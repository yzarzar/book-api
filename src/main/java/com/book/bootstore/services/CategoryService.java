package com.book.bootstore.services;

import java.util.List;

import com.book.bootstore.entity.Category;

public interface CategoryService {
    
    Category createCategory(Category category);
    
    List<Category> getAllCategories();

    Category getCategoryById(int id);

    Category updateCategory(int id, Category category) throws Exception;

    void deleteCategory(int id) throws Exception;
}
