package com.gtpl.Assent.Entity;



import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "super_admins")
public class SuperAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "super_admin_id")
    private Integer superAdminId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;
}

