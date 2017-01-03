package com.mas.domain.model.Users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private LocalDateTime registrationDate = LocalDateTime.now();

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @NotEmpty
    @Size(min = 6)
    @JsonProperty(access = WRITE_ONLY)
    private String password;

}
