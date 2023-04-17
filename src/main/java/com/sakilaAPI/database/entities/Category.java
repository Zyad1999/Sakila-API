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
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "TINYINT UNSIGNED not null")
    private Short id;

    @Column(name = "name", nullable = false, length = 25)
    @NotBlank
    private String name;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    @ToString.Exclude
    private Set<FilmCategory> filmCategories = new LinkedHashSet<>();

}