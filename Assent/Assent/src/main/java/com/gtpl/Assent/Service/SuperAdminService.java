package com.gtpl.Assent.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtpl.Assent.Entity.Admin;
import com.gtpl.Assent.Entity.SuperAdmin;
import com.gtpl.Assent.Repository.SuperAdminRepository;

@Service
public class SuperAdminService {
	
	@Autowired
	private SuperAdminRepository superAdminRepo;

	public SuperAdmin createSuperAdmin(SuperAdmin superadmin) {
		return superAdminRepo.save(superadmin);
	}

	public List<SuperAdmin> getAllAdmins() {
		return superAdminRepo.findAll();
	}

	public void deleteAdmin(Integer id) {
		superAdminRepo.deleteById(id);
	}

	public Optional<SuperAdmin> getSuperAdminById(Integer id) {
		return superAdminRepo.findById(id);
	}

}
