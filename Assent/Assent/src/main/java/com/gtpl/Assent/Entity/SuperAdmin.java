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
    
	public Integer getSuperAdminId() {
		return superAdminId;
	}

	public void setSuperAdminId(Integer superAdminId) {
		this.superAdminId = superAdminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SuperAdmin [superAdminId=" + superAdminId + ", name=" + name + ", email=" + email + "]";
	}
    
    
}

