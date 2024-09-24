package org.example.code.core;

import java.util.List;

public interface IServices<T> {
    void save(T object);

    List<T> show();
}