package com.mas.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Character {
    static final int MAX_DESCRIPTION_LENGTH = 60000;

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Size(max = MAX_DESCRIPTION_LENGTH)
    private String description;

    @JsonIgnore
    @ManyToMany(cascade= CascadeType.ALL, mappedBy="characters", fetch = FetchType.EAGER)
    private Set<Book> books = new HashSet<>();

    public Character(String name, String description){
        this.name = name;
        this.description = description;
    }
}
