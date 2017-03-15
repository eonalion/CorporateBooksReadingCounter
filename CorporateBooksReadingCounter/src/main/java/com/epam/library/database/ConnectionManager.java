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
    private DatabaseInitializer dbInitializer;
    private Connection connection;
    private static ConnectionManager instance;

    public ConnectionManager() {
        createConnection();
    }

    private void createConnection() {
        dbInitializer = new DatabaseInitializer();
        try {
            Class.forName(dbInitializer.DRIVER).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            LOG.fatal("Error while initializing database driver.", e);
            throw new RuntimeException(e);
        }

        try {
            this.connection = DriverManager.getConnection(dbInitializer.URL, dbInitializer.LOGIN, dbInitializer.PASSWORD);
        } catch (SQLException e) {
            LOG.error("Error while getting database connection." + e);
        }
    }

    public static Connection getConnectionInstance() {
        if(instance==null) {
            instance = new ConnectionManager();
        }
        return instance.connection;
    }
}
