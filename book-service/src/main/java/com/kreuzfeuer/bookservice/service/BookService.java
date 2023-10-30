package com.kreuzfeuer.bookservice.service;

import com.kreuzfeuer.bookservice.dto.BookSearchRequest;
import com.kreuzfeuer.bookservice.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getListBookByUserId(String userId);

    Book getBookByIdAndUserId(long id, String userId);

    Long deleteBookByIdAndUserId(Long id, String userId);

    Book saveWithUserId(Book book, String userId);

    Book putBookWithIdAndUserLogin(Long id, Book book, String userId);

    List<BookSearchRequest> getSearchResultsByBookName(String name);
}
