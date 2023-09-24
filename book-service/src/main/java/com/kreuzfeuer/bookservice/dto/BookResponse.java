package com.kreuzfeuer.bookservice.dto;

import com.kreuzfeuer.bookservice.entity.Book;
import com.kreuzfeuer.bookservice.entity.enums.BookRating;
import com.kreuzfeuer.bookservice.entity.enums.BookStatus;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class BookResponse {
    String bookName;

    String author;

    LocalDate dateAdded;

    String description;

    BookStatus status;

    BookRating rating;

    public static BookResponse mappingFromBook(Book book){
        return book == null ?  null:
                BookResponse.builder()
                .bookName(book.getBookName())
                .author(book.getAuthor())
                .dateAdded(book.getDateAdded())
                .description(book.getDescription())
                .status(book.getStatus())
                .rating(book.getRating())
                .build();

    }
}
