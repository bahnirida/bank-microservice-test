package org.example.accountservice.web;

import lombok.extern.slf4j.Slf4j;
import org.example.accountservice.clients.CustomerRestClient;
import org.example.accountservice.entities.BankAccount;
import org.example.accountservice.model.Customer;
import org.example.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
public class AccountController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;
    public AccountController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }
    @GetMapping("/accounts")
    public List<BankAccount> getAllAccounts() {
        return bankAccountRepository.findAll();
    }
    @GetMapping("/accounts/{id}")
    public BankAccount getAccountById(@PathVariable String id) {

        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.getCustomer(bankAccount.getCustomerId());
        log.info("customer :" +customer.toString());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
