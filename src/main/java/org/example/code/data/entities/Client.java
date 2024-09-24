package org.example.code.data.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode

public class Client {
    private String surname;
    private String phone;
    private String address;

    public Client() {

    }

    public Client(String surname, String phone, String address) {
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    private Account account;

    private final List<Debt> debtList = new ArrayList<>();

    public void addDebt(Debt debt) {
        debtList.add(debt);
    }

    @Override
    public String toString() {
        return STR."Client{surname='\{surname}\{'\''}, phone='\{phone}\{'\''}, address='\{address}\{'\''}\{'}'}";
    }
}