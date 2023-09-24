package com.kreuzfeuer.bookservice.entity;

import com.kreuzfeuer.bookservice.entity.enums.BookRating;
import com.kreuzfeuer.bookservice.entity.enums.BookStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false )
    private String bookName;

    private String author;

    @Column(name = "date-add", nullable = false)
    private LocalDate dateAdded;

    private String description;

    @Enumerated(EnumType.STRING)
    private BookStatus status = BookStatus.PLANNED;

    @Enumerated(EnumType.STRING)
    private BookRating rating = BookRating.NONE;

    @Column(nullable = false)
    private String userId;

    @PrePersist
    private void init(){
        dateAdded = LocalDate.now();
    }

    public Book(String bookName, String author, String description, BookStatus status, BookRating rating) {
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.status = status;
        this.rating = rating;
    }
}
