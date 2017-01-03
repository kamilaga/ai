package com.mas.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mas.domain.model.Users.Reader;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRead {
    enum Status {
        PLAN_TO_READ, CURRENTLY_READING, READ
    }

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Status status = Status.PLAN_TO_READ;

    private LocalDateTime dateRead;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Reader reader;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    private Rating rating;

}
