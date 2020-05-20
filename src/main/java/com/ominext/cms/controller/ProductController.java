package com.ominext.cms.controller;

import com.ominext.cms.exception.RecordNotFoundException;
import com.ominext.cms.model.Product;
import com.ominext.cms.service.ProductService;
import com.ominext.cms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;
    private final UserService userService;

    public ProductController(ProductService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @PostMapping
    public void createProduct(Product product) {
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

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return service.getAll();
    }
}
