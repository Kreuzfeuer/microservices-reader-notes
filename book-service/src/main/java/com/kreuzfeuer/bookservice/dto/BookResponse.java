package com.kreuzfeuer.bookservice.dto;

import com.kreuzfeuer.bookservice.entity.enums.BookRating;
import com.kreuzfeuer.bookservice.entity.enums.BookStatus;
import lombok.Value;

import java.time.LocalDate;

@Value
public class BookResponse {
    String bookName;

    String author;

    LocalDate dateAdded;

    String description;

    BookStatus status;

    BookRating rating;
}
