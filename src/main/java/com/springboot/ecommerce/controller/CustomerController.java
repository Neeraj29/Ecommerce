package com.springboot.ecommerce.controller;

import com.springboot.ecommerce.entity.Customer;
import com.springboot.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<?> registeredCustomer(@RequestBody Customer customer) throws Exception{
        Customer newCustomer = customerService.registeredCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateCustomer(@RequestBody Map<String,String> request){
        String email = request.get("email");
        String password = request.get("password");
        boolean result = customerService.customerExists(email,password);
        if(result){
            return ResponseEntity.ok("User Exists");
        }
            return ResponseEntity.status(404).body("User does not exists");

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> retrieveCustomer(@PathVariable Long id){
        Optional<Customer> c = customerService.getCustomer(id);
        if(c.isPresent()){
            return ResponseEntity.ok().body(c);
        }
        else{
            return ResponseEntity.status(404).body("Customer does not exists");
        }
    }
}
