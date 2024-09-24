package org.example.code.core.impl;

import org.example.code.core.IViews;

import java.util.Scanner;

public abstract class ViewsImpl<T> implements IViews<T> {
    protected final Scanner scanner = new Scanner(System.in);

    public int askId() {
        System.out.println("Input an ID:");
        return scanner.nextInt();
    }
}