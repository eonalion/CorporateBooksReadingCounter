package com.epam.library.service;

/**
 *
 */
public class ServiceFactory {
    private ServiceFactory() {
    }

    private static BookService bookService = new BookService();
    private static EmployeeService employeeService = new EmployeeService();

    public static BookService getBookService() {
        return bookService;
    }

    public static EmployeeService getEmployeeService() {
        return employeeService;
    }
}
