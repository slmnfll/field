package org.example.code.data.repositories.interfaces;

import org.example.code.core.IRepositories;
import org.example.code.data.entities.Debt;

public interface IDebtRepository extends IRepositories<Debt> {
    Debt findById(int object);
}