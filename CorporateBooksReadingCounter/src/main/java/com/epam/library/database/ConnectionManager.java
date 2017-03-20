package com.epam.library.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 */
public class ConnectionManager {
    private static final Logger LOG = LogManager.getLogger();
    private Connection connection;
    private static ConnectionManager instance;

    public ConnectionManager() {
        this.connection = createConnection();
    }

    private Connection createConnection() {
        DatabaseInitializer dbInitializer = new DatabaseInitializer();
        try {
            Class.forName(dbInitializer.DRIVER).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            LOG.fatal("Error while initializing database driver.", e);
            throw new RuntimeException("Error while initializing database driver.", e);
        }

        Connection connection;
        try {
            connection = DriverManager.getConnection(dbInitializer.URL, dbInitializer.LOGIN, dbInitializer.PASSWORD);
        } catch (SQLException e) {
            LOG.fatal("Error while getting database connection.", e);
            throw new RuntimeException("Error while getting database connection.", e);
        }
        return connection;
    }

    public static void closeConnection() {
        if (instance != null) {
            try {
                instance.connection.close();
            } catch (SQLException e) {
                LOG.error("Error while closing connection.", e);
            } finally {
                instance = null;
            }
        }
    }

    public static Connection getConnectionInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance.connection;
    }
}
