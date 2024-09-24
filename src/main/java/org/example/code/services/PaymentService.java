package org.example.code.services;

import org.example.code.core.IRepositories;
import org.example.code.core.IServices;
import org.example.code.data.entities.Payment;

import java.util.List;

public class PaymentService implements IServices<Payment> {
    private final IRepositories<Payment> paymentRepository;

    public PaymentService(IRepositories<Payment> paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.insert(payment);
    }

    @Override
    public List<Payment> show() {
        return paymentRepository.selectAll();
    }
}