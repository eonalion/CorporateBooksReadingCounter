package com.epam.library.service;

import com.epam.library.dao.DAOFactory;
import com.epam.library.dao.EmployeeDAO;
import com.epam.library.entity.Employee;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;

import java.util.List;

/**
 *
 */
public class EmployeeService {
    public String showAll() throws ServiceException {
        EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
        List<Employee> employeeList;
        StringBuilder empListReport = new StringBuilder();
        try {
            employeeList = employeeDAO.selectAllEmployees();
            employeeList.forEach(e -> empListReport.append(e).append("\n"));
        } catch (DAOException e) {
            throw new ServiceException("Error while showing all employees", e);
        }
        return empListReport.toString();
    }

    public String getSqlSelectEmpsWithMoreThanOneBook() throws ServiceException {
        try {
            EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
            return employeeDAO.getSqlSelectEmpsWithMoreThanOneBook();
        } catch (DAOException e){
            throw new ServiceException("Error in report service logic", e);
        }

    }

    public String getSqlSelectEmpsWithLessOrEqThanTwoBooks() throws ServiceException {
        try {
            EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
            return employeeDAO.getSqlSelectEmpsWithLessOrEqThanTwoBooks();
        } catch (DAOException e) {
            throw new ServiceException("Error in report service logic", e);
        }
    }


}
