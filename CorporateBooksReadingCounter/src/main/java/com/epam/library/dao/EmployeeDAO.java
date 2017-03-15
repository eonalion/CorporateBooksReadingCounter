package com.epam.library.dao;

import com.epam.library.domain.Employee;
import com.epam.library.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public abstract class EmployeeDAO extends AbstractDAO {
    private Connection connection;

    private static final String SQL_SELECT_ALL_EMPLOYEE = "SELECT * FROM `employee`";
    private static final String SQL_INSERT_EMPLOYEE = "INSERT INTO `employee` (`name`, `date_of_birth`, `email`) VALUES(?,?,?)";
    private static final String SQL_SELECT_EMPLOYEE_BY_ID = "SELECT * FROM `employee` WHERE `id` = ?";
    private static final String SQL_DELETE_EMPLOYEE_BY_ID = "DELETE FROM `employee` WHERE `id` = ?";
    private static final String SQL_DELETE_EMPLOYEE_BY_PARAMS = "DELETE FROM `employee` WHERE `name` = ? AND `date_of_birth` = ? AND `email` = ?";
    private static final String SQL_UPDATE_EMPLOYEE_BY_ID = "UPDATE `employee` SET `name` = ?, `date_of_birth` = ?, `email` = ? WHERE `id` = ?";

    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DATE_OF_BIRTH = "date_of_birth";
    private static final String COLUMN_EMAIL = "email";

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Employee> selectAllBooks() throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_EMPLOYEE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Employee> employeeList = new LinkedList<>();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setName(resultSet.getString(COLUMN_NAME));
                employee.setDateOfBirth(resultSet.getDate(COLUMN_DATE_OF_BIRTH));
                employee.setEmail(resultSet.getString(COLUMN_EMAIL));
                employeeList.add(employee);
            }
            return employeeList;
        } catch (SQLException e) {
            throw new DAOException("Error while selecting all employee" + e);
        }
    }

    public void insertEmployee(String name, Date dateOfBirth, String email) {}
    //public Employee selectEmployeeById(int id) {}
    public void deleteEmployeeById(int id) {}
    public void deleteEmployeeByParams(String name, Date dateOfBirth, String email) {}
    public void updateEmployeeById(int id, String name, Date dateOfBirth, String email) {}
}