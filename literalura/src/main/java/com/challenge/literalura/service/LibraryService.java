package com.challenge.literalura.service;


import com.challenge.literalura.config.GutendexApiClient;
import com.challenge.literalura.model.dto.BookDTO;
import com.challenge.literalura.model.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final com.challenge.literatura.service.BookService bookService;
    private final com.challenge.literatura.service.AuthorService authorService;
    private final GutendexApiClient apiClient;
    private final ObjectMapper objectMapper;

    @Transactional
    public Book addBookByName(String bookName) {
        String apiResponse = apiClient.searchBook(bookName);
        try {
            BookDTO bookDTO = objectMapper.readValue(apiResponse, BookDTO.class);
            return bookService.createFromDTO(bookDTO);
        } catch (Exception e) {
            throw new RuntimeException("Error processing book data: " + e.getMessage());
        }
    }

    // Additional methods
}