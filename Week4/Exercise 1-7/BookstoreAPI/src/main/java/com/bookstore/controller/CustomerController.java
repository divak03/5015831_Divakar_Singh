package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookstore.entity.Customer;
import com.bookstore.service.CustomerService;

import java.net.URI;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.created(URI.create("/customers/" + newCustomer.getId())).body(newCustomer);
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Customer> createCustomerFromForm(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String address) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        Customer newCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.created(URI.create("/customers/" + newCustomer.getId())).body(newCustomer);
    }
}
