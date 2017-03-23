package com.epam.library.dao;

import com.epam.library.database.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 */
public abstract class AbstractDAO {
    private Connection connection;

    public AbstractDAO() {
        connection = ConnectionManager.getConnectionInstance();
    }

    public Connection getConnection() throws SQLException {
        if (connection.isClosed()) {
            connection = ConnectionManager.getConnectionInstance();
        }
        return connection;
    }
}
