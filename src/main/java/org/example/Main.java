package org.example;

import org.example.code.core.*;
import org.example.code.core.factory.*;

import org.example.code.data.entities.*;
import org.example.code.data.repositories.ArticleRepository;
import org.example.code.data.repositories.DebtRepository;
import org.example.code.data.repositories.PaymentRepository;
import org.example.code.data.repositories.interfaces.IArticleRepository;
import org.example.code.data.repositories.interfaces.IDebtRepository;
import org.example.code.entities.*;

import org.example.code.repositories.*;

import org.example.code.services.*;
import org.example.code.services.interfaces.*;

import org.example.code.views.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        IAccountService accountService = ServicesFabric.instanceAccountService();
        AccountView accountView = new AccountView();

        IClientService clientService = ServicesFabric.instanceClientService();
        ClientView clientView = new ClientView();

        IDebtRepository debtRepository = new DebtRepository();
        DebtService debtService = new DebtService(debtRepository);
        DebtView debtView = new DebtView();

        IRepositories<Payment> paymentRepository = new PaymentRepository();
        PaymentService paymentService = new PaymentService(paymentRepository);
        PaymentView paymentView = new PaymentView();

        IArticleRepository articleRepository = new ArticleRepository();
        ArticleService articleService = new ArticleService(articleRepository);
        ArticleView articleView = new ArticleView();

        accountService.save(new Account("S", "F", Role.SHOPKEEPER));
        accountService.save(new Account("Test", "Test", Role.ADMIN));

        int choice;

        Account a;

        do {
            System.out.println("Enter your login:");
            String login = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();

            a = accountService.fetchByLoginAndPassword(login, password);

            if (a == null) {

                System.out.println("\n[User not found...]\n");

            } else if (a.getRole() == Role.SHOPKEEPER) {

                do {
                    switch (choice = menu(scanner)) {
                        case 1 -> {
                            Client client = clientView.instance();
                            if (accountView.askAccountCreate()) {
                                Account account = accountView.instance();
                                client.setAccount(account);
                                account.setClient(client);
                                accountService.save(account);
                                System.out.println("\n[Account created!]");
                            }
                            clientService.save(client);
                            System.out.println("\n[Client saved!]\n");
                        }
                        case 2 -> {
                            System.out.println("\n[All clients:]\n");
                            clientService.show().forEach(System.out::println);
                        }
                        case 3 -> {
                            Client client = clientService.fetchByPhone(clientView.askPhoneNumber());
                            if (client == null) {
                                System.out.println("\n[Client not found...]\n");
                            } else {
                                System.out.println(client);
                            }
                        }
                        case 4 -> {
                            Client client = clientService.fetchByPhone(clientView.askPhoneNumber());
                            if (client == null) {
                                System.out.println("\n[Client not found...]\n");
                            } else {
                                Debt debt = debtView.instance();
                                client.addDebt(debt);
                                debt.setClient(client);
                                debtService.save(debt);
                                System.out.println("\n[Debt saved!]\n");
                            }
                        }
                        case 5 -> {
                            Client client = clientService.fetchByPhone(clientView.askPhoneNumber());
                            if (client == null) {
                                System.out.println("\n[Client not found...]\n");
                            } else {
                                Debt d = debtService.fetchById(client.getDebtList(), debtView.askId());
                                if (d == null) {
                                    System.out.println("\n[Debt not found...]\n");
                                } else {
                                    Payment payment = paymentView.instance();
                                    Debt clientDebt = client.getDebtList().get(d.getId() - 1);
                                    payment.setDebt(clientDebt);
                                    clientDebt.addPayment(payment);
                                    clientDebt.setAmountSent(clientDebt.getAmountSent() + payment.getAmount());
                                    clientDebt.setAmountMissing(clientDebt.getAmountSent() - clientDebt.getAmount());
                                    System.out.println("\n[Payment done!]\n");
                                }
                            }
                        }
                        case 6 -> {
                            Client client = clientService.fetchByPhone(clientView.askPhoneNumber());
                            if (client == null) {
                                System.out.println("\n[Client not found...]\n");
                            } else {
                                client.getDebtList().stream().filter(debt -> debt.getAmountMissing() > 0).forEach(System.out::println);
                            }
                        }
                    }
                } while (choice != 7);

            } else if (a.getRole() == Role.ADMIN) {

                do {

                    switch (choice = menuAdmin(scanner)) {
                        case 1 -> {
                            Client client = clientService.fetchByPhone(clientView.askPhoneNumber());
                            if (client == null) {
                                System.out.println("\n[Client not found...]\n");
                            } else if (client.getAccount() != null) {
                                System.out.println("\n[Client already has an account...]\n");
                            } else {
                                Account account = accountView.instance();
                                client.setAccount(account);
                                account.setClient(client);
                                accountService.save(account);
                                System.out.println("\n[Account created!]");
                            }
                        }
                        case 2 -> {
                            Account account = accountView.instance();
                            if (accountView.askAccountRole()) {
                                account.setRole(Role.ADMIN);
                                accountService.save(account);
                            } else {
                                account.setRole(Role.SHOPKEEPER);
                                accountService.save(account);
                            }
                            System.out.println("\n[Account created!]");
                        }
                        case 3 -> {
                            Account account = accountService.fetchById(accountView.askId());
                            if (account == null) {
                                System.out.println("\n[Account not found...]\n");
                            } else {
                                System.out.println(account.getState());
                                accountService.changeState(account);
                                System.out.println("\n[Account status changed]\n");
                            }
                        }
                        case 4 -> {
                            if (accountView.askAccountRole()) {
                                accountService.show().forEach(e -> {
                                    if (e.getRole() == Role.ADMIN) {
                                        System.out.println(e);
                                    }
                                });
                            } else {
                                accountService.show().forEach(e -> {
                                    if (e.getRole() == Role.SHOPKEEPER) {
                                        System.out.println(e);
                                    }
                                });
                            }
                        }
                        case 5 -> {
                            articleService.save(articleView.instance());
                            System.out.println("\n[Article saved!]\n");
                        }
                        case 6 -> articleService.show().forEach(article -> {
                            if (article.getStock() > 0) {
                                System.out.println(article);
                            }
                        });

                    }

                } while (choice != 8);

            }

        } while (a == null);
    }

    public static int menu(Scanner scanner) {
        System.out.println("1- Create a client");
        System.out.println("2- List all clients");
        System.out.println("3- Find a client by his phone number");
        System.out.println("4- Create a debt");
        System.out.println("5- Create a payment");
        System.out.println("6- Show unpaid debts");
        System.out.println("7- Leave");
        return scanner.nextInt();
    }

    public static int menuAdmin(Scanner scanner) {
        System.out.println("1- Create a account for a client");
        System.out.println("2- Create more users (admin/shopkeeper)");
        System.out.println("3- Activate/Deactivate an account");
        System.out.println("4- Show users account by role");
        System.out.println("5- Create article");
        System.out.println("6- List available articles");
        System.out.println("7- Update an article's stock");
        System.out.println("8- Leave");
        return scanner.nextInt();
    }
}