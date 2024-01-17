package com.book.bootstore.dto;

import java.time.LocalDate;

import com.book.bootstore.entity.BookStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookInfoDTO {
    
    private int id;
    private String title;
    private String bootImg;
    private BookStatus bookStatus;
    private LocalDate yearPublished;
    private String authorFullName;
}
