package com.book.bootstore.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bootstore.dto.BookInfoDTO;
import com.book.bootstore.entity.Book;
import com.book.bootstore.entity.BookStatus;
import com.book.bootstore.repository.BookRepository;
import com.book.bootstore.services.BookService;

import lombok.NonNull;

@Service
public class BookServiceImpl implements BookService{
    
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(@NonNull Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    @Override
    public Book updateBook(int id, Book book) throws Exception {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book updateBook = bookOptional.get();

            updateBook.setTitle(book.getTitle());
            updateBook.setPrice(book.getPrice());
            updateBook.setYearPublished(book.getYearPublished());
            updateBook.setBootImg(book.getBootImg());
            updateBook.setBookStatus(book.getBookStatus());
            updateBook.setAuthor(book.getAuthor());
            updateBook.setCategory(book.getCategory());

            return bookRepository.save(updateBook);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void deleteBook(int id) throws Exception {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new Exception();
        }
    }

    @Override
    public List<BookInfoDTO> getBookInfoByBookStatus(BookStatus bookStatus) {
        return bookRepository.getBookInfoByBookStatus(bookStatus);
    }
}
