package com.epam.library.service;

import com.epam.library.dao.EmployeeDAO;
import com.epam.library.domain.Employee;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class EmployeeService implements IService<Employee> {
    @Override
    public List<Employee> showAll() throws ServiceException {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList = employeeDAO.selectAllEmployees();
        } catch (DAOException e) {
            throw new ServiceException("Error while showing all employees", e);
        }
        return employeeList;
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
