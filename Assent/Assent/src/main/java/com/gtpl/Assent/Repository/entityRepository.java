package com.gtpl.Assent.Repository;

import com.gtpl.Assent.Entity.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface entityRepository extends JpaRepository<entity, Integer> {

}
