package org.example.code.data.repositories;

import org.example.code.core.impl.RepositoriesImpl;
import org.example.code.data.entities.Account;
import org.example.code.data.repositories.interfaces.IAccountRepository;

public class AccountRepository extends RepositoriesImpl<Account> implements IAccountRepository {

    @Override
    public Account findByLoginAndPassword(String login, String password) {
        return list.stream().filter(account -> account.getLogin().compareTo(login) == 0 && account.getPassword().compareTo(password) == 0).findFirst().orElse(null);
    }

    @Override
    public Account findById(int id) {
        return list.stream().filter(account -> account.getId() == id).findFirst().orElse(null);
    }
}