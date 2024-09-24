package org.example.code.data.repositories.interfaces;

import org.example.code.core.IRepositories;
import org.example.code.data.entities.Client;

public interface IClientRepository extends IRepositories<Client>{
    Client findByPhone(String object);
}