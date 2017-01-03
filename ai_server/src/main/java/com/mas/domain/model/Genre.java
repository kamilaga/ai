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
public class Genre {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty
    private String name;

    @JsonIgnore
    @ManyToMany(cascade= CascadeType.ALL, mappedBy="genres", fetch = FetchType.EAGER)
    private Set<Book> books  = new HashSet<>();

    public Genre(String name){
        this.name = name;
    }
}
