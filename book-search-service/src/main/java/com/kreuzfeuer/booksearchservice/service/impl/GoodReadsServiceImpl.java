package com.kreuzfeuer.booksearchservice.service.impl;

import com.kreuzfeuer.booksearchservice.dto.HApiBookResponse;
import com.kreuzfeuer.booksearchservice.service.GoodReadsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodReadsServiceImpl implements GoodReadsService {

    @Value("${rapidApi.uri}")
    private String uri;
    @Value("${rapidApi.headers.key}")
    private String key;
    @Value("${rapidApi.headers.host}")
    private String host;

    private final WebClient webClient = WebClient.builder().build();

    @Override
    public Mono<List<HApiBookResponse>> getBookByName(String name) {
        return webClient.get()
                .uri(uri + name.replace(' ', '+'))
                .header("X-RapidAPI-Key", key)
                .header("X-RapidAPI-Host", host)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<HApiBookResponse>>() {
                })
                .publishOn(Schedulers.boundedElastic());


    }
}
