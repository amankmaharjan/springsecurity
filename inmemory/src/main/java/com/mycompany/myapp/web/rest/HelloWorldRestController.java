package com.mycompany.myapp.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aman on 5/9/17.
 */
@RestController
public class HelloWorldRestController {
    @RequestMapping("/")
    public String welcome() {
        return "welcome to Rest Template Example";
    }

    @RequestMapping("/api")
    public String api() {
        return "welcome to Rest Api";
    }
}

