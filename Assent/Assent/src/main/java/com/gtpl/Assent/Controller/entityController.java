package com.gtpl.Assent.Controller;


import com.gtpl.Assent.Entity.entity;
import com.gtpl.Assent.Service.entityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/entities")
public class entityController {

    @Autowired
    private entityService entityService;

    // Get all entities
    @GetMapping
    public ResponseEntity<List<entity>> getAllEntities() {
        List<entity> entities = entityService.getAllEntities();
        return ResponseEntity.ok(entities);
    }

    // Get an entity by ID
    @GetMapping("/{id}")
    public ResponseEntity<entity> getEntityById(@PathVariable Integer id) {
        Optional<entity> entity = entityService.getEntityById(id);
        return entity.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new entity
    @PostMapping
    public ResponseEntity<entity> createEntity(@RequestBody entity entity) {
        entity createdEntity = entityService.createEntity(entity);
        return ResponseEntity.ok(createdEntity);
    }

    // Update an entity
    @PutMapping("/{id}")
    public ResponseEntity<entity> updateEntity(
            @PathVariable Integer id,
            @RequestBody entity updatedEntity) {
        try {
            entity entity = entityService.updateEntity(id, updatedEntity);
            return ResponseEntity.ok(entity);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an entity
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Integer id) {
        try {
            entityService.deleteEntity(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}