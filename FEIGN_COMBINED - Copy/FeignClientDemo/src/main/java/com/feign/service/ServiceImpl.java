package com.feign.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ServiceImpl {

    private final WebClient.Builder webClientBuilder;


    public ServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String getName(){

        WebClient webClient = webClientBuilder.build();

        return webClient
                .get()
                .uri("http://localhost:8084/demo/name")
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }
}
