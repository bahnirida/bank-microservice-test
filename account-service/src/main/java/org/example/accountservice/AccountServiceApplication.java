package org.example.accountservice;

import org.example.accountservice.entities.BankAccount;
import org.example.accountservice.enums.AccountType;
import org.example.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository) {
        return args -> {
            List<BankAccount> customers =List.of(
                    BankAccount.builder()
                            .accountId(UUID.randomUUID().toString())
                            .currency("dh")
                            .balance(999.99)
                            .creationDate(LocalDate.now())
                            .accountType(AccountType.CURRENT_ACCOUNT)
                            .CustomerId(Long.valueOf(1))
                            .build(),
                    BankAccount.builder()
                            .accountId(UUID.randomUUID().toString())
                            .currency("dh")
                            .balance(9995.99)
                            .creationDate(LocalDate.now())
                            .accountType(AccountType.SAVINGS_ACCOUNT)
                            .CustomerId(Long.valueOf(2))
                            .build());
            bankAccountRepository.saveAll(customers);
        };
    }
}
