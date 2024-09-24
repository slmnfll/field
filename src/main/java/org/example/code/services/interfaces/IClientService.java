package org.example.code.services.interfaces;

import org.example.code.core.IServices;
import org.example.code.data.entities.Client;

public interface IClientService extends IServices<Client> {
    Client fetchByPhone(String object);
}