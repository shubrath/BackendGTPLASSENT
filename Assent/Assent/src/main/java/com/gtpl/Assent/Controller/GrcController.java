package com.gtpl.Assent.Controller;




import org.springframework.web.bind.annotation.*;

import com.gtpl.Assent.Entity.Organization;
import com.gtpl.Assent.Entity.OrganizationProductMapping;
import com.gtpl.Assent.Entity.Product;
import com.gtpl.Assent.Service.GrcService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GrcController {
    private final GrcService grcService;

    public GrcController(GrcService grcService) {
        this.grcService = grcService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return grcService.getAllProducts();
    }

    @GetMapping("/organizations")
    public List<Organization> getOrganizations() {
        return grcService.getAllOrganizations();
    }

    @GetMapping("/mappings")
    public List<OrganizationProductMapping> getMappings() {
        return grcService.getAllMappings();
    }
}

