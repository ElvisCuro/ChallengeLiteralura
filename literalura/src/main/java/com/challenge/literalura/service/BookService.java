package com.challenge.literatura.service;

import com.challenge.literatura.model.dto.BookDTO;
import com.challenge.literatura.model.entity.Book;
import com.challenge.literatura.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book createFromDTO(BookDTO dto) {
        if (bookRepository.existsByTitle(dto.getTitle())) {
            throw new RuntimeException("Book already exists");
        }
        Book book = new Book();
        // Convert DTO to entity
        return bookRepository.save(book);
    }

    public List<Book> getTopBooks(int limit) {
        return bookRepository.findTopByOrderByDownloadsDesc(limit);
    }
}
