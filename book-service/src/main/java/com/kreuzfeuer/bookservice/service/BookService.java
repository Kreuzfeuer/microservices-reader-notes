package com.kreuzfeuer.bookservice.service;

import com.kreuzfeuer.bookservice.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getListBookByUserId(String userId);

    Book deleteBookByIdAndUserId(String userId, Long id);

    Book save(Book book);
}
