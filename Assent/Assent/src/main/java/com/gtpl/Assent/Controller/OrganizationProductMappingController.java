package com.gtpl.Assent.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gtpl.Assent.Entity.OrganizationProductMapping;
import com.gtpl.Assent.Service.OrganizationProductMappingService;

import java.util.List;

@RestController
@RequestMapping("/api/mappings")
public class OrganizationProductMappingController {

    private final OrganizationProductMappingService mappingService;

    public OrganizationProductMappingController(OrganizationProductMappingService mappingService) {
        this.mappingService = mappingService;
    }

    // Create or Update
//    @PostMapping
//    public ResponseEntity<OrganizationProductMapping> createOrUpdateMapping(@RequestBody OrganizationProductMapping mapping) {
//        OrganizationProductMapping savedMapping = mappingService.saveOrUpdateMapping(mapping);
//        return ResponseEntity.ok(savedMapping);
//    }
    
    @PostMapping
    public ResponseEntity<OrganizationProductMapping> createOrUpdateMapping(@RequestBody OrganizationProductMapping mapping) {
        System.out.println("Received Mapping: " + mapping);
        OrganizationProductMapping savedMapping = mappingService.saveOrUpdateMapping(mapping);
        return ResponseEntity.ok(savedMapping);
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<OrganizationProductMapping>> getAllMappings() {
        List<OrganizationProductMapping> mappings = mappingService.getAllMappings();
        return ResponseEntity.ok(mappings);
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationProductMapping> getMappingById(@PathVariable Integer id) {
        return mappingService.getMappingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMappingById(@PathVariable Integer id) {
        mappingService.deleteMappingById(id);
        return ResponseEntity.noContent().build();
    }
}
