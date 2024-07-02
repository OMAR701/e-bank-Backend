package com.example.ebank.service;

import com.example.ebank.dao.AccountRepository;
import com.example.ebank.dao.ClientRepository;
import com.example.ebank.dto.AccountInput;
import com.example.ebank.entities.Account;
import com.example.ebank.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ClientRepository clientRepository;

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account createAccount(AccountInput input) {
        Client client = clientRepository.findById(input.getClientId()).orElseThrow(() -> new RuntimeException("Client not found"));
        Account account = new Account();
        account.setRib(input.getRib());
        account.setClient(client);
        account.setBalance(input.getBalance());
        account.setStatus(input.getStatus());
        return accountRepository.save(account);
    }
}