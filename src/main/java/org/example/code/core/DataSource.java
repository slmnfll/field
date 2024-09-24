package org.example.code.core;

public interface DataSource<T> {
    void openConnection();
    void closeConnection();
    void prepareStatement(String object);
    void executeQuery();
    int executeUpdate();
    String generateSQL(T object, String string);
    void setFields(T object);
}
