package com.gtpl.Assent.Service;


import com.gtpl.Assent.Entity.entity;

import java.util.List;
import java.util.Optional;

public interface entityService {

    // Get all entities
    List<entity> getAllEntities();

    // Get an entity by ID
    Optional<entity> getEntityById(Integer id);

    // Create a new entity
    entity createEntity(entity entity);

    // Update an entity
    entity updateEntity(Integer id, entity updatedEntity);

    // Delete an entity
    void deleteEntity(Integer id);
}