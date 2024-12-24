package com.gtpl.Assent.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtpl.Assent.Entity.Organization;
import com.gtpl.Assent.Repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService{

	 @Autowired
	    private OrganizationRepository organizationRepository;

	    @Override
	    public List<Organization> getAllOrganizations() {
	        return organizationRepository.findAll();
	    }

	    @Override
	    public Optional<Organization> getOrganizationById(Integer id) {
	        return organizationRepository.findById(id);
	    }

	    @Override
	    public Organization createOrganization(Organization organization) {
	        return organizationRepository.save(organization);
	    }

	    @Override
	    public Organization updateOrganization(Integer id, Organization updatedOrganization) {
	        return organizationRepository.findById(id).map(org -> {
	            org.setName(updatedOrganization.getName());
	            org.setSuperAdmin(updatedOrganization.getSuperAdmin());
	            //org.setAdmin(updatedOrganization.getAdmin());
	            return organizationRepository.save(org);
	        }).orElseThrow(() -> new RuntimeException("Organization not found with ID: " + id));
	    }

	    @Override
	    public void deleteOrganization(Integer id) {
	        if (!organizationRepository.existsById(id)) {
	            throw new RuntimeException("Organization not found with ID: " + id);
	        }
	        organizationRepository.deleteById(id);
	    }
	}