package com.epam.library.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 */
class DatabaseInitializer {

    private static final Logger LOG = LogManager.getLogger();

    final String driver;
    final String url;
    final String login;
    final String password;

    DatabaseInitializer() {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("properties.database");
            driver = resourceBundle.getString("db.driver");
            url = resourceBundle.getString("db.url");
            login = resourceBundle.getString("db.login");
            password = resourceBundle.getString("db.password");
        } catch (NumberFormatException | MissingResourceException e) {
            LOG.fatal("Cannot initialize the database connection.", e);
            throw new RuntimeException("Cannot initialize the database connection.", e);
        }
    }
}