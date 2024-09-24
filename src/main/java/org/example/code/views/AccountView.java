package org.example.code.views;

import org.example.code.core.impl.ViewsImpl;
import org.example.code.data.entities.Account;
import org.example.code.data.entities.Role;
import org.example.code.data.entities.State;

public class AccountView extends ViewsImpl<Account> {
    @Override
    public Account instance() {
        Account account = new Account();
        System.out.println("Create a login:");
        account.setLogin(scanner.nextLine());
        System.out.println("Create a password:");
        account.setPassword(scanner.nextLine());
        account.setRole(Role.CLIENT);
        account.setState(State.ENABLED);
        return account;
    }

    public boolean askAccountCreate() {
        System.out.println("Assign an account?\n1- Yes\n2- No");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice == 1;
    }

    public boolean askAccountRole() {
        System.out.println("Admin or Shopkeeper?\n1- Admin\n2- Shopkeeper");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice == 1;
    }
}