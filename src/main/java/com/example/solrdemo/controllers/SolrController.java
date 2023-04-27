package com.example.solrdemo.controllers;

import com.example.solrdemo.data.Product;
import com.example.solrdemo.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/api/products")
public class SolrController {

    private ProductRepository productRepository;

    public SolrController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("add")
    public Product addProduct() {
        Product product = new Product();
        product.setId("1");
        product.setName("Product 1");
        productRepository.save(product, Duration.ofDays(10));
        return product;
    }


    @GetMapping("/")
    public Page<Product> getProduct() {
        return productRepository.findAll(Pageable.ofSize(10));
    }
}
