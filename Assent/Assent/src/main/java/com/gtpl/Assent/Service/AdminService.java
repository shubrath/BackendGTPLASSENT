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
    
    public Optional<Admin> authenticateAdmin(String email, String password) {
        Optional<Admin> adminOpt = adminRepository.findByEmailId(email);
        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();
            // Check if the entered password matches the stored password (no hashing)
            if (password.equals(admin.getPassword())) {
                return Optional.of(admin);  // Authentication success
            }
        }
        return Optional.empty(); // Authentication failed
    }
    
}