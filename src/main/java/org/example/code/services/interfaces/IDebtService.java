package org.example.code.services.interfaces;

import org.example.code.core.IServices;
import org.example.code.data.entities.Debt;

import java.util.List;

public interface IDebtService extends IServices<Debt> {
    Debt fetchById(List<Debt> list, int object);
}