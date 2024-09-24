package org.example.code.data.repositories.interfaces;

import org.example.code.core.IRepositories;
import org.example.code.data.entities.Account;

public interface IAccountRepository extends IRepositories<Account> {
    Account findByLoginAndPassword(String login, String password);

    Account findById(int object);
}