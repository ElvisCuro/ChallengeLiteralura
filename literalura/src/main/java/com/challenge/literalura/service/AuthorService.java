package com.challenge.literatura.service;

import com.challenge.literatura.model.entity.Author;
import com.challenge.literatura.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> findAuthorsAliveInYear(int year) {
        return authorRepository.findByBirthYearLessThanAndDeathYearGreaterThan(year, year);
    }

    public Author findByName(String name) {
        return authorRepository.findByNameContainingIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }
}