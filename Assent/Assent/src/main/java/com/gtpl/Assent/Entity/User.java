package com.gtpl.Assent.Entity;

import jakarta.persistence.*;



@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Column(nullable = false, length = 50)
    private String department;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status;








	public Integer getUserId() {
		return userId;
	}







	public void setUserId(Integer userId) {
		this.userId = userId;
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







	public Organization getOrganization() {
		return organization;
	}







	public void setOrganization(Organization organization) {
		this.organization = organization;
	}







	public String getDepartment() {
		return department;
	}







	public void setDepartment(String department) {
		this.department = department;
	}







	public Status getStatus() {
		return status;
	}







	public void setStatus(Status status) {
		this.status = status;
	}







	public User(Integer userId, String name, String email, Organization organization, String department,
			Status status) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.organization = organization;
		this.department = department;
		this.status = status;
	}







	public User() {
		super();
		// TODO Auto-generated constructor stub
	}







	public enum Status {
		ACTIVE, INACTIVE
	}
}