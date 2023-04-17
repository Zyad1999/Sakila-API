package com.sakilaAPI.database.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id", columnDefinition = "TINYINT UNSIGNED not null")
    private Short id;

    @Column(name = "name", nullable = false, length = 20)
    @NotBlank
    private String name;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "language")
    @ToString.Exclude
    private Set<Film> films = new LinkedHashSet<>();

    @OneToMany(mappedBy = "originalLanguage")
    @ToString.Exclude
    private Set<Film> originalFilms = new LinkedHashSet<>();

}