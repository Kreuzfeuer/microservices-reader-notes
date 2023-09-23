package com.kreuzfeuer.bookservice.service.impl;

import com.kreuzfeuer.bookservice.entity.Book;
import com.kreuzfeuer.bookservice.repository.BookRepository;
import com.kreuzfeuer.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

   public List<Book> getListBookByUserId(String userId){
        return bookRepository.getAllBookByUserId(userId);
    }

    public Book deleteBookByIdAndUserId(String userId, Long id){
        return bookRepository.deleteBookByUserIdAndId(userId,id);
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }
}
