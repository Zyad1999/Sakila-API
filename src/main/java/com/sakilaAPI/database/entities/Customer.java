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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", columnDefinition = "SMALLINT UNSIGNED not null")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    @ToString.Exclude
    private Store store;

    @Column(name = "first_name", nullable = false, length = 45)
    @NotBlank
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    @NotBlank
    private String lastName;

    @Column(name = "email", length = 50)
    @NotBlank
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    @ToString.Exclude
    private Address address;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Column(name = "last_update")
    private Instant lastUpdate;

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private Set<Payment> payments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private Set<Rental> rentals = new LinkedHashSet<>();

}