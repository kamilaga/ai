package com.mas.domain.model.Users;


import com.mas.domain.model.BookRead;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reader extends Person {

//    @Id
//    @GeneratedValue
//    private Integer id;

//    @NotEmpty
//    @Column(unique = true)
//    @Length(min = 4, max = 15)
//    @Pattern(regexp = "^[\\p{IsAlphabetic}\\p{IsDigit}]+$", message = "Username can only contain letters and numbers")
//    private String username;

//    @NotEmpty
//    @Size(min = 6)
//    @JsonProperty(access = WRITE_ONLY)
//    private String password;

    @NotEmpty
    @Column(unique = true)
    private String displayName;

    @OneToMany(mappedBy = "reader", cascade = CascadeType.ALL)
    Set<BookRead> booksRead  = new HashSet<>();

    @Builder
    public Reader(LocalDateTime registrationDate, String email, String password, String displayName) {
        super(null, registrationDate, email, password);
        this.displayName = displayName;
    }

    @Builder
    public Reader(String email, String password, String displayName) {
        this(LocalDateTime.now(), email, password, displayName);
    }

}
