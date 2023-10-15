package com.kreuzfeuer.bookservice.opeignclient;

import com.kreuzfeuer.bookservice.dto.BookSearchRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "book-search-service")
public interface BookSearchClient {

    @GetMapping("/api/v1/book-search/goodreads/{name}")
    List<BookSearchRequest> getResultOfSearchingBooksByName(@PathVariable("name") String name);
}
