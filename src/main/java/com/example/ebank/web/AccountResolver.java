package com.example.ebank.web;

import com.example.ebank.dto.AccountInput;
import com.example.ebank.entities.Account;
import com.example.ebank.service.AccountService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    private AccountService accountService;

    public Account getAccount(Long id) {
        return accountService.getAccountById(id);
    }

    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    public Account createAccount(AccountInput input) {
        return accountService.createAccount(input);
    }
}