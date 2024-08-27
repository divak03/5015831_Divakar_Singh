package com.bookstore.controller;
import com.bookstore.service.CustomMetricsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final CustomMetricsService customMetricsService;

    // Constructor-based dependency injection
    @Autowired
    public OrderController(CustomMetricsService customMetricsService) {
        this.customMetricsService = customMetricsService;
    }

    @PostMapping
    public void createOrder() {
        // Order creation logic goes here

        // Correctly calling the incrementCounter method to increase the counter
        customMetricsService.incrementCounter();
    }
}