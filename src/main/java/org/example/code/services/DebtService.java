package org.example.code.services;

import org.example.code.data.entities.Debt;
import org.example.code.data.repositories.interfaces.IDebtRepository;
import org.example.code.services.interfaces.IDebtService;

import java.util.List;

public class DebtService implements IDebtService {
    private final IDebtRepository debtRepository;

    public DebtService(IDebtRepository debtRepository) {
        this.debtRepository = debtRepository;
    }

    @Override
    public void save(Debt debt) {
        debtRepository.insert(debt);
    }

    @Override
    public List<Debt> show() {
        return debtRepository.selectAll();
    }

    @Override
    public Debt fetchById(List<Debt> list, int id) {
        return list.stream().filter(debt -> debt.getId() == id).findFirst().orElse(null);
    }
}