package dev.manoj.productserviceapplication.controllers;

import dev.manoj.productserviceapplication.models.Product;
import dev.manoj.productserviceapplication.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController { // waiter
    private ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {

        return productService.getProductById(id);

    }

    //localhost:8080/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}