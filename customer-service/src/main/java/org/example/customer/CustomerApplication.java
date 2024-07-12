package org.example.customer;

import org.example.customer.config.GlobalConfig;
import org.example.customer.entities.Customer;
import org.example.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> customers =List.of(
					Customer.builder().firstname("rida").lastname("bahni").email("rida@gmail.com").build(),
					Customer.builder().firstname("rida1").lastname("bahni").email("rida1@gmail.com").build());
			customerRepository.saveAll(customers);
		};
	}
}
