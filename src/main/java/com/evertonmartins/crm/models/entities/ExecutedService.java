package com.evertonmartins.crm.models.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_executed_service")
public class ExecutedService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String description;

    private BigDecimal price;

    private String observations;

    @OneToMany(mappedBy = "id.executedService")
    private Set<OrderItem> items = new HashSet<>();

    public ExecutedService() {
    }
}
