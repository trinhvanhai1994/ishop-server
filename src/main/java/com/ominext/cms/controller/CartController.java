package com.ominext.cms.controller;

import com.ominext.cms.response.CartResponse;
import com.ominext.cms.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @GetMapping
    public CartResponse addToCart(@RequestParam Long productId, @RequestParam Long userId) {
        service.addToCart(productId, userId);
        return service.cartInfo(userId);
    }

    @DeleteMapping
    public CartResponse deleteItem(@RequestParam Long productId, @RequestParam Long userId) {
        service.deleteCartItem(userId, productId);
        return service.cartInfo(userId);
    }
}
