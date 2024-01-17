package com.book.bootstore.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bootstore.dto.AuthorAndBookDTO;
import com.book.bootstore.entity.Author;
import com.book.bootstore.repository.AuthorRepository;
import com.book.bootstore.services.AuthorService;

import lombok.NonNull;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author createAuthor(@NonNull Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<AuthorAndBookDTO> getAuthorAndBookDetails() {
            return authorRepository.findAuthorAndBookDetails();
    }

    @Override
    public List<Author> listAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(int id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        return optionalAuthor.orElse(null);
    }

    @Override
    public Author updateAuthor(int id, Author author) throws Exception{
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            Author existingAuthor = optionalAuthor.get();
            existingAuthor.setFirstName(author.getFirstName());
            existingAuthor.setLastName(author.getLastName());
            existingAuthor.setEmail(author.getEmail());
            existingAuthor.setDateOfBirth(author.getDateOfBirth());
            existingAuthor.setBioInfo(author.getBioInfo());
            existingAuthor.setImageName(author.getImageName());
            existingAuthor.setBooks(author.getBooks());

            return authorRepository.save(existingAuthor);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void deleteAuthor(int id) throws Exception {
        Optional<Author> authorOptional = authorRepository.findById(id);
        
        if (authorOptional.isPresent()) {
            authorRepository.deleteById(id);
        } else {
            throw new Exception();
        }
    }
}
