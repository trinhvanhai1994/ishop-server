package com.ominext.cms.web;

import com.ominext.cms.exception.RecordNotFoundException;
import com.ominext.cms.model.Product;
import com.ominext.cms.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        service.save(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) throws RecordNotFoundException {
        return service.getProduct(id);
    }

    @PutMapping("/{id}")
    public void editProduct(@PathVariable Long id, @RequestBody Product product) throws RecordNotFoundException {
        service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return service.getAll();
    }
}
