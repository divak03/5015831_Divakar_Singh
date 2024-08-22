package com.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
