package org.example.code.data.repositories;

import org.example.code.core.impl.RepositoriesBDImpl;
import org.example.code.data.entities.Client;
import org.example.code.data.repositories.interfaces.IClientRepository;

import java.sql.SQLException;

public class ClientRepositoryBD extends RepositoriesBDImpl<Client> implements IClientRepository {

    /*
    @Override
    public List<Client> selectAll() {
        List<Client> clients = new ArrayList<>();
        try {
            openConnection();
            executeQuery("SELECT * FROM `client`");
            while (resultSet.next()) {
                clients.add(new Client(resultSet.getString("surname"), resultSet.getString("phone"), resultSet.getString("address")));
            }
        } catch (SQLException e) {
            System.out.println("[Database operation failed!]");
        }
        return clients;
    }
     */

    @Override
    public Client findByPhone(String phone) {
        Client client = null;
        try {
            openConnection();
            //executeQuery(String.format("SELECT * FROM `client` WHERE `phone`= '%s';", phone));
            while (resultSet.next()) {
                client = new Client(resultSet.getString("surname"), resultSet.getString("phone"), resultSet.getString("address"));
            }
        } catch (SQLException e) {
            System.out.println("[Database operation failed!]");
        }
        return client;
    }
}