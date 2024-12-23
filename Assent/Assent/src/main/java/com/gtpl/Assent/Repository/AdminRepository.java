package com.gtpl.Assent.Repository;

import com.gtpl.Assent.Entity.Admin;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	Optional<Admin> findByEmailId(String emailId);

}