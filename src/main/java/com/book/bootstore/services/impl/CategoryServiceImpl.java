package com.book.bootstore.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bootstore.entity.Category;
import com.book.bootstore.repository.CategoryRepository;
import com.book.bootstore.services.CategoryService;

import lombok.NonNull;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(@NonNull Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
       return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(null);
    }

    @Override
    public Category updateCategory(int id, Category category) throws Exception{
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isPresent()) {
            Category updateCategory = categoryOptional.get();

            updateCategory.setCategoryName(category.getCategoryName());

            return categoryRepository.save(updateCategory);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void deleteCategory(int id) throws Exception {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryRepository.deleteById(id);
        } else {
            throw new Exception();
        }
    }
}
