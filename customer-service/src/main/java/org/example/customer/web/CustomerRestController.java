package org.example.customer.web;

import org.example.customer.entities.Customer;
import org.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CustomerRestController {
    private  CustomerRepository customerRepository;
    @Autowired
    public CustomerRestController(CustomerRepository CustomerRepository) {
        this.customerRepository = CustomerRepository;
    }
    @GetMapping("/all-customers")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id).get();
    }
}
