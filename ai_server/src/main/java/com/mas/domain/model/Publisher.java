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
public class Publisher {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String website;

    @JsonIgnore
    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    Set<Edition> editions  = new HashSet<>();

    public Publisher(String name, String website){
        this.name = name;
        this.website = website;
    }

    public Publisher fillUpdateData(Publisher publisher) {
        this.name = publisher.name;
        this.website = publisher.website;
        return this;
    }
}
