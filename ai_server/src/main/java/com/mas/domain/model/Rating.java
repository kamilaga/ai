package com.mas.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Min(value = 0)
    @Max(value = 5)
    private int score;

    private String comment;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "rating", optional = false)
    private BookRead bookRead;
}
