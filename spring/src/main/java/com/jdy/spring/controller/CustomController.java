package com.jdy.spring.controller;

import com.jdy.spring.domain.Customer;
import com.jdy.spring.domain.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class CustomController {

    @Resource
    private CustomerRepository repository;

    @PostMapping(value = "/insert",produces = "application/json")
    public Customer insert(@RequestBody Customer customer){
        return repository.save(customer);
    }

    @GetMapping(value = "/{id}")
    public Customer findOne(@PathVariable Long id){
        return repository.findOne(id);
    }

}
