package org.example.code.core;

import java.util.List;

public interface IRepositories<T> {
    void insert(T object);

    List<T> selectAll();
}