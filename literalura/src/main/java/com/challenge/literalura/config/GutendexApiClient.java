package com.challenge.literalura.config;

import org.springframework.stereotype.Component;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class GutendexApiClient {
    private static final String API_BASE = "https://gutendex.com/books/?search=";
    private final HttpClient client;

    public GutendexApiClient() {
        this.client = HttpClient.newHttpClient();
    }

    public String searchBook(String query) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_BASE + query.replace(" ", "%20")))
                .build();

        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching book data: " + e.getMessage());
        }
    }
}