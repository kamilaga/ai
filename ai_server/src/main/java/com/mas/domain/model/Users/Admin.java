package com.mas.domain.model.Users;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Person {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String phoneNumber;

    @Builder
    public Admin(LocalDateTime registrationDate, String email, String password, String firstName, String lastName, String phoneNumber) {
        super(null, registrationDate, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Builder
    public Admin(String email, String password, String firstName, String lastName, String phoneNumber) {
        this(LocalDateTime.now(), email, password, firstName, lastName, phoneNumber);

    }
}


