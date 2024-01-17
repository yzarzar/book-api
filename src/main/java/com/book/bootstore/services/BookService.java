package com.book.bootstore.services;

import java.util.List;

import com.book.bootstore.dto.BookInfoDTO;
import com.book.bootstore.entity.Book;
import com.book.bootstore.entity.BookStatus;

public interface BookService {
    
    Book createBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(int id);

    Book updateBook(int id, Book book) throws Exception;

    void deleteBook(int id) throws Exception;

    List<BookInfoDTO> getBookInfoByBookStatus(BookStatus bookStatus);
}
