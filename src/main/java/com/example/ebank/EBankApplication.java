package com.example.ebank;

import com.example.ebank.dao.AccountRepository;
import com.example.ebank.dao.ClientRepository;
import com.example.ebank.entities.Account;
import com.example.ebank.entities.Client;
import com.example.ebank.enums.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class EBankApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(EBankApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Client client1 = new Client();
        client1.setFirstName("John");
        client1.setLastName("Doe");
        client1.setIdentityNumber("123456789");
        client1.setBirthDate(LocalDate.of(1990, 1, 1));
        client1.setEmail("john.doe@example.com");
        client1.setPostalAddress("123 Main St");

        clientRepository.save(client1);

        Account account1 = new Account();
        account1.setRib("RIB123456");
        account1.setClient(client1);
        account1.setBalance(new BigDecimal("1000.00"));
        account1.setStatus(AccountStatus.OPEN);

        accountRepository.save(account1);

    }

}
