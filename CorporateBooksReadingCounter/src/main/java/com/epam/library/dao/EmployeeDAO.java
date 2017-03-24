package com.epam.library.dao;

import com.epam.library.entity.Employee;
import com.epam.library.exception.DAOException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class EmployeeDAO extends AbstractDAO {
    private static final String SQL_SELECT_ALL_EMPLOYEES = "SELECT * FROM employee";
    private static final String SQL_INSERT_EMPLOYEE = "INSERT INTO employee (`name`, `date_of_birth`, `email`) VALUES(?,?,?)";
    private static final String SQL_SELECT_EMPLOYEE_BY_ID = "SELECT * FROM `employee` WHERE `id` = ?";
    private static final String SQL_DELETE_EMPLOYEE_BY_ID = "DELETE FROM `employee` WHERE `id` = ?";
    private static final String SQL_DELETE_EMPLOYEE_BY_PARAMS = "DELETE FROM `employee` WHERE `name` = ? AND `date_of_birth` = ? AND `email` = ?";
    private static final String SQL_UPDATE_EMPLOYEE_BY_ID = "UPDATE `employee` SET `name` = ?, `date_of_birth` = ?, `email` = ? WHERE `id` = ?";
    private static final String SQL_SELECT_EMPS_WITH_MORE_THAN_ONE_BOOK = "SELECT e.name, COUNT(b_e.book_id) number_of_books FROM employee e\n" +
            "      INNER JOIN book_has_employee b_e ON e.id = b_e.employee_id\n" +
            "      GROUP BY e.id\n" +
            "      HAVING number_of_books > 1\n" +
            "      ORDER BY number_of_books";
    private static final String SQL_SELECT_EMPS_WITH_LESS_OR_EQ_THAN_TWO_BOOKS = "SELECT e.name, e.date_of_birth, COUNT(b_e.book_id) number_of_books FROM employee e\n" +
            "      INNER JOIN book_has_employee b_e ON e.id = b_e.employee_id\n" +
            "      GROUP BY e.id\n" +
            "      HAVING number_of_books <= 2\n" +
            "      ORDER BY number_of_books";

    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DATE_OF_BIRTH = "date_of_birth";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_NUMBER_OF_BOOKS = "number_of_books";

    public List<Employee> selectAllEmployees() throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_ALL_EMPLOYEES)) {
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
            throw new DAOException("Error while selecting all employee.", e);
        }
    }

    public Employee selectEmployeeById(int id) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_EMPLOYEE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Employee employee = new Employee();
            employee.setName(resultSet.getString(COLUMN_NAME));
            employee.setDateOfBirth(resultSet.getDate(COLUMN_DATE_OF_BIRTH));
            employee.setEmail(resultSet.getString(COLUMN_EMAIL));
            return employee;
        } catch (SQLException e) {
            throw new DAOException("Error while selecting employee by id.", e);
        }
    }

    public void insertEmployee(String name, LocalDate dateOfBirth, String email) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_INSERT_EMPLOYEE)) {
            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, Date.valueOf(dateOfBirth));
            preparedStatement.setString(3, email);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Error while inserting new employee.", e);
        }
    }

    public void deleteEmployeeById(int id) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_DELETE_EMPLOYEE_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Error while inserting new employee.", e);
        }
    }

    public void deleteEmployeeByParameters(String name, LocalDate dateOfBirth, String email) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_DELETE_EMPLOYEE_BY_PARAMS)) {
            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, Date.valueOf(dateOfBirth));
            preparedStatement.setString(3, email);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Error while inserting new employee.", e);
        }
    }

    public void updateEmployeeById(int id, String name, LocalDate dateOfBirth, String email) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_UPDATE_EMPLOYEE_BY_ID)) {
            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, Date.valueOf(dateOfBirth));
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Error while inserting new employee.", e);
        }
    }

    public String getSqlSelectEmpsWithMoreThanOneBook() throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_EMPS_WITH_MORE_THAN_ONE_BOOK)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder report = new StringBuilder();
            while (resultSet.next()) {
                String name = resultSet.getString(COLUMN_NAME);
                int booksAmount = resultSet.getInt(COLUMN_NUMBER_OF_BOOKS);
                report.append(name).append(": \t").append(booksAmount).append("\n");
            }
            return report.toString();
        } catch (SQLException e) {
            throw new DAOException("Error while selecting employees with more than one book.", e);
        }
    }

    public String getSqlSelectEmpsWithLessOrEqThanTwoBooks() throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_EMPS_WITH_LESS_OR_EQ_THAN_TWO_BOOKS)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder report = new StringBuilder();
            while (resultSet.next()) {
                String name = resultSet.getString(COLUMN_NAME);
                String dateOfBirth = resultSet.getString(COLUMN_DATE_OF_BIRTH);
                int booksAmount = resultSet.getInt(COLUMN_NUMBER_OF_BOOKS);
                report.append(name).append(", \t").append(dateOfBirth).append(": \t").append(booksAmount).append("\n");
            }
            return report.toString();
        } catch (SQLException e) {
            throw new DAOException("Error while selecting employees with more than one book.", e);
        }
    }
}
