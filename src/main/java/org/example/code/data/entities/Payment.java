package org.example.code.data.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Payment {
    private static int counter;
    private int id;
    private String date;
    private int amount;

    private Debt debt;
}