package com.kreuzfeuer.bookservice.controller;

import ch.qos.logback.core.model.Model;
import com.kreuzfeuer.bookservice.dto.BookResponse;
import com.kreuzfeuer.bookservice.entity.Book;
import com.kreuzfeuer.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/book-service")
@RequiredArgsConstructor

public class BasicBookController {

    private final BookService bookService;


    @GetMapping("/")
    public List<BookResponse> getAllBooks() {


        return null;
    }

    @GetMapping("/book-delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {

        bookService.deleteBookByIdAndUserId("egor", 1L);
        return "redirect:/user-note";
    }

    @GetMapping("/book-add")
    public String addUserBookForm(Model model) {

        return "book-add";
    }

    @PostMapping("/book-add")
    public String addUserBook() {


        return "redirect:/user-note";
    }

    @GetMapping("/book-update/{id}")
    public String updateBookForm() {


        return "book-update";
    }

    @PostMapping("/book-update")
    public BookResponse updateUserBook() {


        return null;
    }
}
