package org.example.code.data.repositories;

import org.example.code.core.impl.RepositoriesImpl;
import org.example.code.data.entities.Client;
import org.example.code.data.repositories.interfaces.IClientRepository;

public class ClientRepository extends RepositoriesImpl<Client> implements IClientRepository {
    @Override
    public Client findByPhone(String phone) {
        return list.stream().filter(client -> client.getPhone().compareTo(phone) == 0).findFirst().orElse(null);
    }
}