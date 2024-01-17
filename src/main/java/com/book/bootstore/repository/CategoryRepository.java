package com.book.bootstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.bootstore.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
