package org.example.code.views;

import org.example.code.core.impl.ViewsImpl;
import org.example.code.data.entities.Debt;

public class DebtView extends ViewsImpl<Debt> {
    @Override
    public Debt instance() {
        Debt debt = new Debt();
        System.out.println("Debt's date:");
        debt.setDate(scanner.nextLine());
        System.out.println("Debt's amount:");
        debt.setAmount(scanner.nextInt());
        debt.setAmountMissing(debt.getAmount());
        debt.setAmountSent(0);
        return debt;
    }
}