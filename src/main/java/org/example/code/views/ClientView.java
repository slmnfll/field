package org.example.code.views;

import org.example.code.core.impl.ViewsImpl;
import org.example.code.data.entities.Client;

public class ClientView extends ViewsImpl<Client> {
    @Override
    public Client instance() {
        Client client = new Client();
        System.out.println("Client's name:");
        client.setSurname(scanner.nextLine());
        System.out.println("Client's phone number:");
        client.setPhone(scanner.nextLine());
        System.out.println("Client's address:");
        client.setAddress(scanner.nextLine());
        return client;
    }

    public String askPhoneNumber() {
        System.out.println("Input a phone number:");
        return scanner.nextLine();
    }
}