package org.example.code.services.interfaces;

import org.example.code.core.IServices;
import org.example.code.data.entities.Account;

public interface IAccountService extends IServices<Account> {
    Account fetchByLoginAndPassword(String login, String password);

    void changeState(Account object);

    Account fetchById(int object);
}