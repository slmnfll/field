package org.example.code.core.impl;

import org.example.code.core.IRepositories;

import java.util.List;

public abstract class RepositoriesBDImpl<T> extends DataSourceImpl<T> implements IRepositories<T> {
    @Override
    public void insert(T object) {
        openConnection();
        prepareStatement(generateSQL(object, "INSERT"));
        setFields(object);
        executeUpdate();
    }

    @Override
    public List<T> selectAll() {
        return null;
    }

    /*
        RETURN_GENERATED_KEY
        PreparedStatement
        connection.prepareStatement(sql)

        preparedStatement.setString(1, data.getStuff())
     */
}