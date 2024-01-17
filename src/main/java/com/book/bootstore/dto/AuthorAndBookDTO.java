package com.book.bootstore.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorAndBookDTO {
    
    private int bookId;
    private String authorFullName;
    private String bookTitle;
    private String categoryName;
    private LocalDate yearPublished;
}
