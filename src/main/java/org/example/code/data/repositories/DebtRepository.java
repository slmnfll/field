package org.example.code.data.repositories;

import org.example.code.core.impl.RepositoriesImpl;
import org.example.code.data.entities.Debt;
import org.example.code.data.repositories.interfaces.IDebtRepository;

public class DebtRepository extends RepositoriesImpl<Debt> implements IDebtRepository {
    @Override
    public Debt findById(int id) {
        return list.stream().filter(debt -> debt.getId() == id).findFirst().orElse(null);
    }
}