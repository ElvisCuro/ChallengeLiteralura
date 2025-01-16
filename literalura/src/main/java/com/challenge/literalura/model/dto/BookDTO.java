package com.challenge.literalura.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class BookDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("authors")
    private List<AuthorDTO> authors;

    @JsonProperty("languages")
    private List<String> languages;

    @JsonProperty("download_count")
    private Long downloadCount;

    @JsonProperty("subjects")
    private List<String> genres;
}