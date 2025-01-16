package com.challenge.literalura.repository;

import com.challenge.literatura.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByTitle(String title);
    List<Book> findByLanguage(String language);

    @Query("SELECT b FROM Book b ORDER BY b.downloads DESC LIMIT :limit")
    List<Book> findTopByOrderByDownloadsDesc(int limit);

    Book findByTitleContainingIgnoreCase(String title);
}
