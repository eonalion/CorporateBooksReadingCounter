package com.epam.library.dao;

/**
 *
 */
public class DAOFactory {
    private static BookDAO bookDAO = new BookDAO();
    private static EmployeeDAO employeeDAO = new EmployeeDAO();

    public static BookDAO getBookDAO() {
        return bookDAO;
    }

    public static EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }
}
