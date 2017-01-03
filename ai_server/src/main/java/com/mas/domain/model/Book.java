package com.mas.domain.model;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    static final int MAX_DESCRIPTION_LENGTH = 60000;

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty
    private String title;

    @NotEmpty
    @Size(max = MAX_DESCRIPTION_LENGTH)
    private String description;

//    @JsonProperty(access = WRITE_ONLY)
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Edition> editions = new HashSet<>();

//    @JsonProperty(access = WRITE_ONLY)
    @ManyToMany
    @Size(min = 1)
    Set<Author> authors = new HashSet<>();

//    @JsonProperty(access = WRITE_ONLY)
    @ManyToMany()
    Set<Character> characters = new HashSet<>();

//    @JsonProperty(access = WRITE_ONLY)
    @ManyToMany()
    Set<Genre> genres = new HashSet<>();

//    @JsonProperty(access = WRITE_ONLY)
    @OneToMany(mappedBy = "book")
    Set<BookRead> booksRead = new HashSet<>();

//    @JsonProperty(access = WRITE_ONLY)
    @ManyToMany()
    Set<Series> series = new HashSet<>();

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Book fillUpdateData(Book book){
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.authors = book.getAuthors();
        this.characters = book.getCharacters();
        this.genres = book.getGenres();
        this.series = book.getSeries();
        this.editions.clear();
        this.editions.addAll(book.getEditions());
        this.editions.forEach(edition -> edition.setBook(this));
        return this;
    }
}
