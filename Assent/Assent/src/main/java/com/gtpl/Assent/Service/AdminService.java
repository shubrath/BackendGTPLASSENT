package com.gtpl.Assent.Service;

import com.gtpl.Assent.Entity.Admin;
import com.gtpl.Assent.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        return adminRepository.findById(id).map(admin -> {
            admin.setName(updatedAdmin.getName());
            admin.setEmailId(updatedAdmin.getEmailId());
            admin.setPassword(updatedAdmin.getPassword());
            return adminRepository.save(admin);
        }).orElseThrow(() -> new RuntimeException("Admin not found with id " + id));
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}