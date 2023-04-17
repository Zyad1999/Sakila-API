package com.sakilaAPI.database.entities;

import jakarta.persistence.*;
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
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id", columnDefinition = "TINYINT UNSIGNED not null")
    private Short id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_staff_id", nullable = false)
    @ToString.Exclude
    private Staff managerStaff;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    @ToString.Exclude
    private Address address;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "store")
    @ToString.Exclude
    private Set<Inventory> inventories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "store")
    @ToString.Exclude
    private Set<Staff> staff = new LinkedHashSet<>();

    @OneToMany(mappedBy = "store")
    @ToString.Exclude
    private Set<Customer> customers = new LinkedHashSet<>();

}