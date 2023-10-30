package com.kreuzfeuer.bookservice.repository;

import com.kreuzfeuer.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getAllBookByUserId(String userName);

    Long deleteBookByIdAndUserId(Long id, String userId);

    Book save(Book book);

    Book getBookByIdAndUserId(Long id, String userId);
}
