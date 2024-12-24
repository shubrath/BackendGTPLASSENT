package com.gtpl.Assent.Service;



import org.springframework.stereotype.Service;

import com.gtpl.Assent.Entity.OrganizationProductMapping;
import com.gtpl.Assent.Repository.OrganizationProductMappingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationProductMappingService {

    private final OrganizationProductMappingRepository mappingRepository;

    public OrganizationProductMappingService(OrganizationProductMappingRepository mappingRepository) {
        this.mappingRepository = mappingRepository;
    }

//    // Create or Update
//    public OrganizationProductMapping saveOrUpdateMapping(OrganizationProductMapping mapping) {
//        return mappingRepository.save(mapping);
//    }
    
    public OrganizationProductMapping saveOrUpdateMapping(OrganizationProductMapping mapping) {
        if (mapping.getOrganization() == null || mapping.getOrganization().getOrganizationId() == null) {
            throw new IllegalArgumentException("Invalid Organization ID");
        }
        if (mapping.getProduct() == null || mapping.getProduct().getProductId() == null) {
            throw new IllegalArgumentException("Invalid Product ID");
        }

        return mappingRepository.save(mapping);
    }

    // Read All
    public List<OrganizationProductMapping> getAllMappings() {
        return mappingRepository.findAll();
    }

    // Read by ID
    public Optional<OrganizationProductMapping> getMappingById(Integer mappingId) {
        return mappingRepository.findById(mappingId);
    }

    // Delete by ID
    public void deleteMappingById(Integer mappingId) {
        mappingRepository.deleteById(mappingId);
    }
}

