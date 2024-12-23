package com.gtpl.Assent.Service;

import com.gtpl.Assent.Entity.entity;
import com.gtpl.Assent.Repository.entityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class entityServiceImpl implements entityService {

    @Autowired
    private entityRepository entityRepository;

    @Override
    public List<entity> getAllEntities() {
        return entityRepository.findAll();
    }

    @Override
    public Optional<entity> getEntityById(Integer id) {
        return entityRepository.findById(id);
    }

    @Override
    public entity createEntity(entity entity) {
        return entityRepository.save(entity);
    }

    @Override
    public entity updateEntity(Integer id, entity updatedEntity) {
        return entityRepository.findById(id).map(entity -> {
            entity.setEntityName(updatedEntity.getEntityName());
            entity.setEntityDesc(updatedEntity.getEntityDesc());
            entity.setOrganization(updatedEntity.getOrganization());
            entity.setAdmin(updatedEntity.getAdmin());
            return entityRepository.save(entity);
        }).orElseThrow(() -> new RuntimeException("Entity not found with ID: " + id));
    }

    @Override
    public void deleteEntity(Integer id) {
        if (!entityRepository.existsById(id)) {
            throw new RuntimeException("Entity not found with ID: " + id);
        }
        entityRepository.deleteById(id);
    }
}