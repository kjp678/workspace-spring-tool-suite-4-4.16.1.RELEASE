package com.feign.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
