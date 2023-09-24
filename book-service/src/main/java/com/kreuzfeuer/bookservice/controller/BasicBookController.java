package com.kreuzfeuer.bookservice.controller;

import com.kreuzfeuer.bookservice.dto.BookRequest;
import com.kreuzfeuer.bookservice.dto.BookResponse;
import com.kreuzfeuer.bookservice.entity.Book;
import com.kreuzfeuer.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController()
@RequestMapping("/book-service")
@RequiredArgsConstructor

public class BasicBookController {

    private final BookService bookService;


    @GetMapping("/")
    public ResponseEntity<List<BookResponse>> getAllBooks(Principal principal) {

        List<Book> listBook = bookService.getListBookByUserId(principal.getName());
        return ResponseEntity.ok(listBook.stream().map(BookResponse::mappingFromBook).toList());

    }
    //TODO: A successful response MUST be 200 (OK) if the server response includes a message body,
    // 202 (Accepted) if the DELETE action has not yet been performed,
    // or 204 (No content) if the DELETE action has been completed
    // but the response does not have a message body
    @DeleteMapping("/book-delete/{id}")
    public ResponseEntity<BookResponse> deleteBook(@PathVariable("id") Long id, Principal principal) {

        return ResponseEntity.ok(BookResponse.mappingFromBook(bookService.deleteBookByIdAndUserId(id, principal.getName())));

    }
    //TODO: ResponseStatus
    @PostMapping("/book-add")
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest bookRequest, Principal principal) {
        Book book = BookRequest.mappingToBook(bookRequest);

        Book savedBook = bookService.saveWithUserId(book, principal.getName());

        return ResponseEntity.ok(BookResponse.mappingFromBook(savedBook));
    }

    //TODO: f a new resource is created, the origin server MUST inform the client with a 201 (Created)
    // status code. If an existing resource has been modified, status codes 200 (OK)
    // or 204 (No Content) SHOULD be returned to indicate to the client that the request was successful.
    // If the resource cannot be created or modified, an appropriate error code MUST be returned
    // that reflects the nature of the problem (usually 500x)
    @PutMapping("/book-update/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable("id") Long id, @RequestBody BookRequest bookRequest, Principal principal) {

        Book savedBook = bookService.saveWithUserId(BookRequest.mappingToBook(bookRequest), principal.getName());
        return ResponseEntity.ok(BookResponse.mappingFromBook(savedBook));
    }

}
