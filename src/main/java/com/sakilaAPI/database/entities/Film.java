package com.sakilaAPI.database.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
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
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", columnDefinition = "SMALLINT UNSIGNED not null")
    private Integer id;

    @Column(name = "title", nullable = false, length = 128)
    @NotBlank
    private String title;

    @Lob
    @Column(name = "description")
    @NotBlank
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_id", nullable = false)
    @ToString.Exclude
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_language_id")
    @ToString.Exclude
    private Language originalLanguage;

    @Column(name = "rental_duration", columnDefinition = "TINYINT UNSIGNED not null")
    private Short rentalDuration;

    @Column(name = "rental_rate", nullable = false, precision = 4, scale = 2)
    private BigDecimal rentalRate;

    @Column(name = "length", columnDefinition = "SMALLINT UNSIGNED")
    private Integer length;

    @Column(name = "replacement_cost", nullable = false, precision = 5, scale = 2)
    private BigDecimal replacementCost;

    @Column(name = "rating", length = 5)
    private String rating;

    @Column(name = "special_features", length = 54)
    private String specialFeatures;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "film")
    @ToString.Exclude
    private Set<Inventory> inventories = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "film")
    @ToString.Exclude
    private Set<FilmActor> filmActors = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "film")
    @ToString.Exclude
    private Set<FilmCategory> filmCategories = new LinkedHashSet<>();

}