package com.mas.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Edition {
    public enum Format {
        EBOOK, AUDIO, HARDCOVER, PAPERBACK
    }

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Format format;

    @NotEmpty @JsonProperty(value = "ISBN")
    private String ISBN;

    @NotNull
    private LocalDate datePublished;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false)
    private Publisher publisher;

    @JsonIgnore
    @ManyToOne
    private Book book;

    public Edition(Format format, String ISBN, LocalDate datePublished, Publisher publisher) {
        this.format = format;
        this.ISBN = ISBN;
        this.datePublished = datePublished;
        this.publisher = publisher;
    }
}
