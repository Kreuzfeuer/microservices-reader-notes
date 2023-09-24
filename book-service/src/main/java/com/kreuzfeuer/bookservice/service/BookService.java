package com.kreuzfeuer.bookservice.service;

import com.kreuzfeuer.bookservice.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getListBookByUserId(String userId);

    Book deleteBookByIdAndUserId(Long id, String userId);

    Book saveWithUserId(Book book, String userId);
}
