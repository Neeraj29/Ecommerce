package com.springboot.ecommerce.repository;

import com.springboot.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository  extends JpaRepository<Customer,Long> {
    Optional<Customer> findByid(Long id);
    Optional<Customer> findByname(String name);
    Optional<Customer>  findByemail(String email);
    Optional<Customer> findBypassword(String password);
}
