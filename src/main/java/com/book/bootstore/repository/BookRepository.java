package com.book.bootstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.book.bootstore.dto.BookInfoDTO;
import com.book.bootstore.entity.Book;
import com.book.bootstore.entity.BookStatus;

public interface BookRepository extends JpaRepository<Book, Integer> {
    
    @Query("SELECT new com.book.bootstore.dto.BookInfoDTO(b.id, b.title, b.bookImg, b.bookStatus, b.yearPublished, CONCAT(a.firstName, ' ', a.lastName)) " +
           "FROM Book b JOIN b.author a WHERE b.bookStatus = :status")
    List<BookInfoDTO> getBookInfoByBookStatus(@Param("status") BookStatus bookStatus);
}
