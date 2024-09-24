package org.example.code.core.impl;

import org.example.code.core.DataSource;

import java.lang.reflect.Field;
import java.sql.*;

public abstract class DataSourceImpl<T> implements DataSource<T> {
    protected Connection connection;
    protected PreparedStatement statement;
    protected ResultSet resultSet;
    private final String url = "jdbc:mysql://localhost:8889/L3";
    private final String user = "root";
    private final String password = "root";

    @Override
    public void openConnection() {
        if (connection == null || statement == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("[Connection error!]");
            }
        }
    }

    @Override
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) connection.close();
        } catch (SQLException e) {
            System.out.println("[Error closing connection!]");
        }
    }

    @Override
    public void prepareStatement(String sql) {
        try {
            if (sql.toUpperCase().contains("INSERT")) {
                statement = connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
            } else {
                statement = connection.prepareStatement(sql);
            }
        } catch (SQLException e) {
            System.out.println("[Database operation failed!]");
        }
    }

    @Override
    public int executeUpdate() {
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[Database operation failed!]");
        }
        return 1;
    }

    @Override
    public void executeQuery() {
        try {
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("[Database operation failed!]");
        }
    }

    @Override
    public String generateSQL(T object, String string) {
        Class<?> objectClass = object.getClass();
        String tableName = objectClass.getSimpleName().toLowerCase();
        Field[] fields = objectClass.getDeclaredFields();

        StringBuilder sql = new StringBuilder();

        if ("INSERT".equalsIgnoreCase(string)) {

            sql.append("INSERT INTO ").append(tableName).append(" (");

            for (int i = 0; i < fields.length; i++) {
                sql.append(fields[i].getName());
                if (i < fields.length - 1) {
                    sql.append(", ");
                }
            }

            sql.append(") VALUES (");

            for (int i = 0; i < fields.length; i++) {
                sql.append("?");
                if (i < fields.length - 1) {
                    sql.append(", ");
                }
            }

            sql.append(");");
        } else if ("SELECT".equalsIgnoreCase(string)) {

            sql.append("SELECT * FROM ").append(tableName).append(";");
        }

        System.out.println(sql);

        return sql.toString();
    }

    @Override
    public void setFields(T object) {
        Class<?> objectClass = object.getClass();
        Field[] fields = objectClass.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                Object value = fields[i].get(object);
                statement.setObject(i + 1, value);
            } catch (IllegalAccessException | SQLException e) {
                System.out.println("[Error setting field value!]");
            }
        }
    }
}