package com.gtpl.Assent.Service;




import org.springframework.stereotype.Service;

import com.gtpl.Assent.Entity.Organization;
import com.gtpl.Assent.Entity.OrganizationProductMapping;
import com.gtpl.Assent.Entity.Product;
import com.gtpl.Assent.Repository.OrganizationProductMappingRepository;
import com.gtpl.Assent.Repository.OrganizationRepository;
import com.gtpl.Assent.Repository.ProductRepository;
import com.gtpl.Assent.Repository.SuperAdminRepository;

import java.util.List;

@Service
public class GrcService {
    private final ProductRepository productRepository;
    private final SuperAdminRepository superAdminRepository;
    private final OrganizationRepository organizationRepository;
    private final OrganizationProductMappingRepository mappingRepository;

    public GrcService(ProductRepository productRepository, SuperAdminRepository superAdminRepository,
                      OrganizationRepository organizationRepository,
                      OrganizationProductMappingRepository mappingRepository) {
        this.productRepository = productRepository;
        this.superAdminRepository = superAdminRepository;
        this.organizationRepository = organizationRepository;
        this.mappingRepository = mappingRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    public List<OrganizationProductMapping> getAllMappings() {
        return mappingRepository.findAll();
    }
    
    
}
