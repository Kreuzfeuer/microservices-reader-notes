package com.kreuzfeuer.booksearchservice.service;

import com.kreuzfeuer.booksearchservice.dto.HApiBookResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface GoodReadsService {
    Mono<List<HApiBookResponse>> getBookByName(String name);
}
