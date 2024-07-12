package org.example.accountservice.clients;

import org.example.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{customerId}")
    Customer getCustomer(@PathVariable Long customerId);
    @GetMapping("/all-customers")
    List<Customer> getCustomers();
}
