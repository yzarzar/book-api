package com.book.bootstore.services;

import java.util.List;

import com.book.bootstore.dto.AuthorAndBookDTO;
import com.book.bootstore.entity.Author;

/**
 * AuthorService
 */
public interface AuthorService {

    Author createAuthor(Author author);

    public List<AuthorAndBookDTO> getAuthorAndBookDetails();

    List<Author> listAllAuthors();

    Author getAuthorById(int id);

    Author updateAuthor(int id, Author author) throws Exception;

    void deleteAuthor(int id) throws Exception;
}