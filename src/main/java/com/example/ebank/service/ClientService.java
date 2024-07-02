package com.example.ebank.service;

import com.example.ebank.dao.ClientRepository;
import com.example.ebank.dao.UserRepository;
import com.example.ebank.dto.ClientInput;
import com.example.ebank.entities.Client;
import com.example.ebank.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserRepository userRepository;

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client createClient(ClientInput input) {
        User user = userRepository.findById(input.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Client client = new Client();
        client.setFirstName(input.getFirstName());
        client.setLastName(input.getLastName());
        client.setIdentityNumber(input.getIdentityNumber());
        client.setBirthDate(input.getBirthDate());
        client.setEmail(input.getEmail());
        client.setPostalAddress(input.getPostalAddress());
        client.setUser(user);
        return clientRepository.save(client);
    }
}