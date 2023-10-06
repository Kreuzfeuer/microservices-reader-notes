package com.kreuzfeuer.bookservice.service.impl;

import com.kreuzfeuer.bookservice.entity.Book;
import com.kreuzfeuer.bookservice.repository.BookRepository;
import com.kreuzfeuer.bookservice.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public List<Book> getListBookByUserId(String userId) {
        return bookRepository.getAllBookByUserId(userId);
    }

    @Transactional
    public Long deleteBookByIdAndUserId(Long id, String userId) {
        return bookRepository.deleteBookByIdAndUserId(id, userId);
    }

    public Book saveWithUserId(Book book, String userId) {
        book.setUserId(userId);
        return bookRepository.save(book);
    }

    public Book putBookWithIdAndUserLogin(Long id, Book book, String userId) {
        book.setId(id);
        book.setUserId(userId);
        return bookRepository.save(book);
    }
}
