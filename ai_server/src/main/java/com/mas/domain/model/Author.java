package com.mas.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @NonNull
    private String websiteUrl;

    @JsonIgnore()
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "authors", fetch = FetchType.EAGER)
    private Set<Book> books = new HashSet<>();

    public Author(String firstName, String lastName, String websiteUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.websiteUrl = websiteUrl;
    }

    public Author fillUpdateData(Author author){
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        this.websiteUrl = author.getWebsiteUrl();
        return this;
    }

}
