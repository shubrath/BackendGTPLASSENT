package com.gtpl.Assent.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "organization_product_mapping")
public class OrganizationProductMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mapping_id")
    private Integer mappingId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}

