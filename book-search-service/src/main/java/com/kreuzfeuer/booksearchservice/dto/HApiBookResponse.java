package com.kreuzfeuer.booksearchservice.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

@Data
public class HApiBookResponse {
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

