package com.codingdojo.hellohuman;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping("/")
    public String firstName(@RequestParam(name = "first", required = false) String firstName, @RequestParam(name = "last", required = false) String lastName) {
        if(firstName == null) {
            return "Hello, your search returned NULL";
        }else{
            return "Hello, your search returned: " + firstName + " " + lastName;
        }
    }
}
