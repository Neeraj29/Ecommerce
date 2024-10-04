package com.springboot.ecommerce;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
     @GetMapping("/welcome")
    public String welcome(){
        return "Hello";
    }
}
