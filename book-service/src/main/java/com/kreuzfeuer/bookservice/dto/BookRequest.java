package com.kreuzfeuer.bookservice.dto;

import com.kreuzfeuer.bookservice.entity.Book;
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

    public static Book mappingToBook(BookRequest bookRequest) {
        return new Book(bookRequest.getBookName(),
                bookRequest.getAuthor(),
                bookRequest.getDescription(),
                bookRequest.getStatus(),
                bookRequest.getRating());
    }
}
