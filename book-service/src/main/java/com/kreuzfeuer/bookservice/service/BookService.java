package com.kreuzfeuer.bookservice.service;

import com.kreuzfeuer.bookservice.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getListBookByUserId(String userId);

    Long deleteBookByIdAndUserId(Long id, String userId);

    Book saveWithUserId(Book book, String userId);

    Book putBookWithIdAndUserLogin(Long id, Book book, String userId);
}
