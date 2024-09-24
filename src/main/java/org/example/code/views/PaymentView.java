package org.example.code.views;

import org.example.code.core.impl.ViewsImpl;
import org.example.code.data.entities.Payment;

public class PaymentView extends ViewsImpl<Payment> {
    @Override
    public Payment instance() {
        Payment payment = new Payment();
        System.out.println("Payment's date:");
        payment.setDate(scanner.nextLine());
        System.out.println("Payment's amount:");
        payment.setAmount(scanner.nextInt());
        return payment;
    }
}