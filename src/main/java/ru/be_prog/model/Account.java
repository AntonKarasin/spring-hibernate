package ru.be_prog.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Account {

    @Id
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;
}