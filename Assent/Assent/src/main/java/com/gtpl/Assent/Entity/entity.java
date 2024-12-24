package com.gtpl.Assent.Entity;


import jakarta.persistence.*;



@Entity
@Table(name = "entities")
public class entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id")
    private Integer entityId;

    @Column(name = "entity_name", nullable = false, length = 100)
    private String entityName;

    @Column(name = "entity_desc", length = 255)
    private String entityDesc;

    @ManyToOne(optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @ManyToOne(optional = false)
    @JoinColumn(name = "admin_id", nullable = false)
    private Admin admin;

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityDesc() {
		return entityDesc;
	}

	public void setEntityDesc(String entityDesc) {
		this.entityDesc = entityDesc;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public entity(Integer entityId, String entityName, String entityDesc, Organization organization, Admin admin) {
		super();
		this.entityId = entityId;
		this.entityName = entityName;
		this.entityDesc = entityDesc;
		this.organization = organization;
		this.admin = admin;
	}

	public entity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    
}