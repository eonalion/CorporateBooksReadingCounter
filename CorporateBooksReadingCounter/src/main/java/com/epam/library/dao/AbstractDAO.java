package com.epam.library.dao;

import com.epam.library.database.ConnectionManager;

import java.sql.Connection;

/**
 *
 */
public abstract class AbstractDAO {
    private Connection connection;

    public AbstractDAO() {
        connection = ConnectionManager.getConnectionInstance();
    }

    public Connection getConnection(){
        return connection;
    }

}