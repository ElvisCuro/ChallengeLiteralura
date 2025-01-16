package com.challenge.literalura.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    private String genre;
    private String language;
    private String imageUrl;
    private Long downloads;

    public Book(String title, Author author, String genre, String language) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.language = language;
        this.downloads = 0L;
    }
}