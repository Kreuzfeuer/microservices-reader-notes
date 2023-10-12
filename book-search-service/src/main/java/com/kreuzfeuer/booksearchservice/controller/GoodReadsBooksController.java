package com.kreuzfeuer.booksearchservice.controller;

import com.kreuzfeuer.booksearchservice.dto.HApiBookResponse;
import com.kreuzfeuer.booksearchservice.service.GoodReadsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/book-search/goodreads")
@RequiredArgsConstructor
public class GoodReadsBooksController {

    private final GoodReadsService goodReadsService;

    @GetMapping("/{name}")
    public Mono<List<HApiBookResponse>> getBooksByName(@PathVariable("name") String name) {
        return goodReadsService.getBookByName(name);

    }

}
