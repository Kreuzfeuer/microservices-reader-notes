package com.kreuzfeuer.bookservice.dto;

import com.kreuzfeuer.bookservice.entity.enums.BookRating;
import com.kreuzfeuer.bookservice.entity.enums.BookStatus;
import lombok.Value;

@Value
public class BookRequest {
    String bookName;

    String author;

    String description;

    BookStatus status;

    BookRating rating;

}
