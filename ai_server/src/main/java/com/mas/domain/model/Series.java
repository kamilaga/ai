package com.mas.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Series {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @JsonIgnore
    @ManyToMany(cascade= CascadeType.ALL, mappedBy="series", fetch = FetchType.EAGER)
    private Set<Book> books  = new HashSet<>();

    public Integer getBooksCount(){
        return books.size();
    }

    public Series(String name){
        this.name = name;
    }
}
