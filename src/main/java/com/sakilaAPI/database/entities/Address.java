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
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", columnDefinition = "SMALLINT UNSIGNED not null")
    private Integer id;

    @Column(name = "address", nullable = false, length = 50)
    @NotBlank
    private String address;

    @Column(name = "address2", length = 50)
    private String address2;

    @Column(name = "district", nullable = false, length = 20)
    @NotBlank
    private String district;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @ToString.Exclude
    private City city;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "phone", nullable = false, length = 20)
    @NotBlank
    private String phone;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "address")
    @ToString.Exclude
    private Set<Staff> staff = new LinkedHashSet<>();

    @OneToMany(mappedBy = "address")
    @ToString.Exclude
    private Set<Store> stores = new LinkedHashSet<>();
    @OneToMany(mappedBy = "address")
    @ToString.Exclude
    private Set<Customer> customers = new LinkedHashSet<>();

}