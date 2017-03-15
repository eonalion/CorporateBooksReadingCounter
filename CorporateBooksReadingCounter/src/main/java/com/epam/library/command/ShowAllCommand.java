package com.epam.library.command;


import com.epam.library.domain.Book;
import com.epam.library.domain.Employee;
import com.epam.library.exception.ServiceException;
import com.epam.library.service.BookService;
import com.epam.library.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ShowAllCommand implements ICommand {

    private static final Logger LOG = LogManager.getLogger();
    @Override
    public String execute(String params) {
        StringBuffer report = new StringBuffer();
        try {
            switch (params) {
                case "book":
                    BookService bookService = new BookService();
                    List<Book> bookList = bookService.showAll();
                    bookList.forEach(b -> report.append(b).append("\n"));
                    break;
                case "employee":
                    EmployeeService employeeService = new EmployeeService();
                    List<Employee> employees = employeeService.showAll();
                    employees.forEach(e -> report.append(e).append("\n"));
                    break;
            }
        } catch (ServiceException e) {
            LOG.error("Error while executing show all command", e);
        }

        return report.toString();
    }
}
