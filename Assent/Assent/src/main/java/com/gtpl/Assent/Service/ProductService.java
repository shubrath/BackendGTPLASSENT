package com.gtpl.Assent.Service;


import com.gtpl.Assent.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    // Get all products
    List<Product> getAllProducts();

    // Get a product by ID
    Optional<Product> getProductById(Integer id);

    // Create a new product
    Product createProduct(Product product);

    // Update an existing product
    Product updateProduct(Integer id, Product updatedProduct);

    // Delete a product
    void deleteProduct(Integer id);
}