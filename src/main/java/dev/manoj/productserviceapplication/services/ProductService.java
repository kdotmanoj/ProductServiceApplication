package dev.manoj.productserviceapplication.services;

import dev.manoj.productserviceapplication.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();
}