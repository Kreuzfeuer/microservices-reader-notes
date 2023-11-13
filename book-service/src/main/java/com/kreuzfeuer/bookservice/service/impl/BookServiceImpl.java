package com.kreuzfeuer.bookservice.service.impl;

import com.kreuzfeuer.bookservice.dto.BookSearchRequest;
import com.kreuzfeuer.bookservice.entity.Book;
import com.kreuzfeuer.bookservice.entity.enums.BookStatus;
import com.kreuzfeuer.bookservice.event.AddPlannedBookEvent;
import com.kreuzfeuer.bookservice.opeignclient.BookSearchClient;
import com.kreuzfeuer.bookservice.repository.BookRepository;
import com.kreuzfeuer.bookservice.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookSearchClient bookSearchClient;
    private final KafkaTemplate<String, AddPlannedBookEvent> kafkaTemplate;

    @Override
    public List<Book> getListBookByUserId(String userId) {
        return bookRepository.getAllBookByUserId(userId);
    }

    @Override
    public Book getBookByIdAndUserId(long id, String userId) {
        return bookRepository.getBookByIdAndUserId(id, userId);
    }

    @Override
    @Transactional
    public Long deleteBookByIdAndUserId(Long id, String userId) {
        return bookRepository.deleteBookByIdAndUserId(id, userId);
    }

    @Override
    public Book saveWithUserId(Book book, String userId) {
        if (book.getStatus() == BookStatus.PLANNED) {
            kafkaTemplate.send("plannedBookTopic", new AddPlannedBookEvent(userId,
                    "You have added a book \"" + book.getBookName()
                            + "\" with the status planned! Don't forget to read this book!"));
        }
        book.setUserId(userId);
        return bookRepository.save(book);
    }

    @Override
    public List<BookSearchRequest> getSearchResultsByBookName(String name) {
        return bookSearchClient.getResultOfSearchingBooksByName(name);
    }

    @Override
    public Book putBookWithIdAndUserLogin(Long id, Book book, String userId) {
        book.setId(id);
        book.setUserId(userId);
        return bookRepository.save(book);
    }
}
