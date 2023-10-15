package com.kreuzfeuer.bookservice.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

@Data
public class BookSearchRequest {
    @JsonAlias("book_id")
    Long bookId;
    String name;
    String cover;
    String url;
    List<String> authors;
    double rating;
    @JsonAlias("created_editions")
    long createdEditions;
    int year;
}
