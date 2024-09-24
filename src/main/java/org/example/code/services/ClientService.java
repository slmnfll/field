package org.example.code.services;

import org.example.code.data.entities.Client;
import org.example.code.data.repositories.interfaces.IClientRepository;
import org.example.code.services.interfaces.IClientService;

import java.util.List;

public class ClientService implements IClientService {
    private final IClientRepository clientRepository;

    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void save(Client client) {
        clientRepository.insert(client);
    }

    @Override
    public List<Client> show() {
        return clientRepository.selectAll();
    }

    @Override
    public Client fetchByPhone(String phone) {
        return clientRepository.findByPhone(phone);
    }
}