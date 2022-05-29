package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorld {

    @GetMapping(path = "/helloworld")
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping(path = "/helloworld/bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("test");
    }

    @GetMapping(path = "/helloworld/variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(name);
    }
}
