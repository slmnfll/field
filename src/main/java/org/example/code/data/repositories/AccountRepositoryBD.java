package org.example.code.data.repositories;

import org.example.code.core.impl.RepositoriesBDImpl;
import org.example.code.data.entities.Account;
import org.example.code.data.repositories.interfaces.IAccountRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryBD extends RepositoriesBDImpl<Account> implements IAccountRepository {
    @Override
    public void insert(Account object) {
        openConnection();
        // executeUpdate(String.format("INSERT INTO `account` (`login`, `password`, `client_id`) VALUES ('%s', '%s', '%d')", object.getLogin(), object.getPassword(), object.getClient()));
    }

    @Override
    public List<Account> selectAll() {
        List<Account> accounts = new ArrayList<>();
        try {
            openConnection();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `account`");
            while (resultSet.next()) {
                accounts.add(new Account(resultSet.getString("login"), resultSet.getString("password")));
            }
        } catch (SQLException e) {
            System.out.println("[Database operation failed!]");
        }
        return accounts;
    }

    @Override
    public Account findByLoginAndPassword(String login, String password) {
        return null;
    }

    @Override
    public Account findById(int object) {
        return null;
    }
}