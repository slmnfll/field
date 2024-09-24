package org.example.code.services;

import org.example.code.data.entities.Account;
import org.example.code.data.entities.State;
import org.example.code.data.repositories.interfaces.IAccountRepository;
import org.example.code.services.interfaces.IAccountService;

import java.util.List;

public class AccountService implements IAccountService {
    private final IAccountRepository accountRepository;

    public AccountService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void save(Account account) {
        accountRepository.insert(account);
    }

    @Override
    public List<Account> show() {
        return accountRepository.selectAll();
    }

    @Override
    public Account fetchByLoginAndPassword(String login, String password) {
        return accountRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public void changeState(Account account) {
        if (account.getState() == State.ENABLED) {
            account.setState(State.DISABLED);
        } else {
            account.setState(State.ENABLED);
        }
    }

    @Override
    public Account fetchById(int id) {
        return accountRepository.selectAll().stream().filter(account -> account.getId() == id).findFirst().orElse(null);
    }
}