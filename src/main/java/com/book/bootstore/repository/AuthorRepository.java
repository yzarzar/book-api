package com.book.bootstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.book.bootstore.dto.AuthorAndBookDTO;
import com.book.bootstore.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

    @Query("SELECT new com.book.bootstore.dto.AuthorAndBookDTO(b.id,CONCAT(a.firstName, ' ', a.lastName), b.title, b.yearPublished) FROM Author a JOIN Book b ON a.id = b.author.id")
    List<AuthorAndBookDTO> findAuthorAndBookDetails();
}
