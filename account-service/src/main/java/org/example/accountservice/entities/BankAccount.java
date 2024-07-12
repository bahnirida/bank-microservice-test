package org.example.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.accountservice.enums.AccountType;
import org.example.accountservice.model.Customer;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate creationDate;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long CustomerId;
    @Transient
    private Customer customer;


}
