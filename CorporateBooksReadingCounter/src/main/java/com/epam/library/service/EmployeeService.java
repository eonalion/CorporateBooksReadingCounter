package com.epam.library.service;

import com.epam.library.dao.EmployeeDAO;
import com.epam.library.domain.Employee;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;

import java.util.List;

/**
 *
 */
public class EmployeeService implements IService<Employee> {
    @Override
    public String showAll() throws ServiceException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employeeList;
        StringBuffer empListReport = new StringBuffer();
        try {
            employeeList = employeeDAO.selectAllEmployees();
            employeeList.forEach(e -> empListReport.append(e).append("\n"));
        } catch (DAOException e) {
            throw new ServiceException("Error while showing all employees", e);
        }
        return empListReport.toString();
    }

    @Override
    public void insert(Employee employee) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Employee employee) {

    }

    @Override
    public void showById(int id) {

    }
}
