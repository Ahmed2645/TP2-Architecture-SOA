package com.example.client.service;

import com.example.client.models.Client;
import com.example.client.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(String id) {
        return clientRepository.findById(id);
    }

    public Optional<Client> updateClient(String id, Client updatedClient) {
        return clientRepository.findById(id).map(existing -> {
            existing.setName(updatedClient.getName());
            existing.setEmail(updatedClient.getEmail());
            existing.setPhone(updatedClient.getPhone());
            existing.setAddress(updatedClient.getAddress());
            return clientRepository.save(existing);
        });
    }

    public boolean deleteClient(String id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}