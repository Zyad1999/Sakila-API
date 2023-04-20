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
@SqlResultSetMapping(name = "inventory_in_stock_mapping", columns = @ColumnResult(name = "result", type = Boolean.class))
@NamedNativeQuery(name = "Inventory.isInventoryInStock", query = "SELECT inventory_in_stock(:p_inventory_id) AS result", resultSetMapping = "inventory_in_stock_mapping")
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    @ToString.Exclude
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    @ToString.Exclude
    private Store store;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "inventory")
    @ToString.Exclude
    private Set<Rental> rentals = new LinkedHashSet<>();

}