package org.example.code.core.factory;

import org.example.code.services.AccountService;
import org.example.code.services.ClientService;
import org.example.code.services.interfaces.IAccountService;
import org.example.code.services.interfaces.IClientService;

public class ServicesFabric {
    private static IClientService clientService = null;
    private static IAccountService accountService = null;

    private ServicesFabric() {
    }

    public static IClientService instanceClientService() {
        if (clientService == null) {
            clientService = new ClientService(RepositoriesFabric.instanceClientRepository());
        }
        return clientService;
    }

    public static IAccountService instanceAccountService() {
        if (accountService == null) {
            accountService = new AccountService(RepositoriesFabric.instanceAccountRepository());
        }
        return accountService;
    }
}