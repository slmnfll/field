package org.example.code.core.factory;

import org.example.code.data.repositories.AccountRepository;
import org.example.code.data.repositories.ClientRepositoryBD;
import org.example.code.data.repositories.interfaces.IAccountRepository;
import org.example.code.data.repositories.interfaces.IClientRepository;

public class RepositoriesFabric {
    private static IClientRepository clientRepository = null;
    private static IAccountRepository accountRepository = null;

    private RepositoriesFabric() {
    }

    public static IClientRepository instanceClientRepository() {
        if (clientRepository == null) {
            clientRepository = new ClientRepositoryBD();
        }
        return clientRepository;
    }

    public static IAccountRepository instanceAccountRepository() {
        if (accountRepository == null) {
            accountRepository = new AccountRepository();
        }
        return accountRepository;
    }
}