package ru.be_prog.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "profiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Profile {

    @Id
    private UUID id;

    @Column(name="date_of_birth")
    private String dateOfBirth;

    @Column(name="country")
    private String country;

    @Column(name="about")
    private String about;

}
