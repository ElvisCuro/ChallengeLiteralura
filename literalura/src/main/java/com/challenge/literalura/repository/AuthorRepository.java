package com.challenge.literalura.repository;

import com.challenge.literatura.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByBirthYearLessThanAndDeathYearGreaterThan(int birthYear, int deathYear);
    Optional<Author> findByNameContainingIgnoreCase(String name);
}