package com.gtpl.Assent.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gtpl.Assent.Entity.SuperAdmin;
import com.gtpl.Assent.Service.SuperAdminService;

@RestController
@RequestMapping("/api/superadmins")
public class SuperAdminController {
	
	@Autowired
	private SuperAdminService superadminService;
	
	@RequestMapping("/")
	public String greet() {
		return "Hello Super Admin";
	}
	
	
	@PostMapping("/createsuperadmin")
    public SuperAdmin createSuperAdmin(@RequestBody SuperAdmin superadmin) {
        return superadminService.createSuperAdmin(superadmin);
    }
	
	@GetMapping("/getsuperadmins")
    public List<SuperAdmin> getAllSuperAdmin() {
        return superadminService.getAllAdmins();
    }
	
	
	@DeleteMapping("/deletesuperadmin/{id}")
    public ResponseEntity<SuperAdmin> deleteSuperAdmin(@PathVariable Integer id) {
		superadminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
	
	@GetMapping("/getsuperadmins/{id}")
    public ResponseEntity<SuperAdmin> getSuperAdminById(@PathVariable Integer id) {
        return superadminService.getSuperAdminById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	

}
