package com.book.bootstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.bootstore.dto.BookInfoDTO;
import com.book.bootstore.entity.Book;
import com.book.bootstore.entity.BookStatus;
import com.book.bootstore.services.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/book")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> postBook(@RequestBody Book book) {
        Book saveBook = bookService.createBook(book);
        return new ResponseEntity<>(saveBook, HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) throws Exception{
        Book getBook = bookService.getBookById(id);
        if (getBook != null) {
            return new ResponseEntity<>(getBook, HttpStatus.OK);
        } else {
            throw new Exception();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Book> putBook(@PathVariable int id, @RequestBody Book book) throws Exception {
        Book updateBook = bookService.updateBook(id, book);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) throws Exception{
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byStatus")
    public ResponseEntity<List<BookInfoDTO>> getBookInfoByBookStatus(@RequestParam("status") BookStatus bookStatus) {
        List<BookInfoDTO> booksInfo = bookService.getBookInfoByBookStatus(bookStatus);
        return new ResponseEntity<>(booksInfo, HttpStatus.OK);
    }
    
}
