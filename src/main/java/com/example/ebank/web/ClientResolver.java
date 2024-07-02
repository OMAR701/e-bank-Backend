package com.example.ebank.web;

import com.example.ebank.dto.ClientInput;
import com.example.ebank.entities.Client;
import com.example.ebank.service.ClientService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    private ClientService clientService;

    public Client getClient(Long id) {
        return clientService.getClientById(id);
    }

    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    public Client createClient(ClientInput input) {
        return clientService.createClient(input);
    }
}