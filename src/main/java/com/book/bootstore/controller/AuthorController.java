package com.book.bootstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.bootstore.dto.AuthorAndBookDTO;
import com.book.bootstore.entity.Author;
import com.book.bootstore.services.AuthorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/author")
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;

    @PostMapping
    private ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author saveAuthor = authorService.createAuthor(author);
        return new ResponseEntity<>(saveAuthor, HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public List<AuthorAndBookDTO> getAuthorAndBookDetails() {
        return authorService.getAuthorAndBookDetails();
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        List<Author> listAllAuthors = authorService.listAllAuthors();
        return listAllAuthors;
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") int id) throws Exception {
        Author author = authorService.getAuthorById(id);
        if (author != null) {
            return new ResponseEntity<>(author, HttpStatus.OK);
        } else {
            throw new Exception("Author not found with ID : " + id);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Author> putAuthor(@PathVariable("id") int id, @RequestBody Author author)throws Exception {
        Author updateAuthor = authorService.updateAuthor(id, author);
        return new ResponseEntity<>(updateAuthor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable("id") int id) throws Exception {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
