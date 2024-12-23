package com.gtpl.Assent.Service;


import com.gtpl.Assent.Entity.Organization;

import java.util.List;
import java.util.Optional;

public interface OrganizationService {

    // Get all organizations
    List<Organization> getAllOrganizations();

    // Get organization by ID
    Optional<Organization> getOrganizationById(Integer id);

    // Create a new organization
    Organization createOrganization(Organization organization);

    // Update an existing organization
    Organization updateOrganization(Integer id, Organization updatedOrganization);

    // Delete an organization
    void deleteOrganization(Integer id);
}