package com.epam.library.dao;

import com.epam.library.entity.Book;
import com.epam.library.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class BookDAO extends AbstractDAO {
    private static final String SQL_SELECT_ALL_BOOKS = "SELECT * FROM `book`";
    private static final String SQL_INSERT_BOOK = "INSERT INTO `book`(`title`, `author`, `brief`, `publish_year`) VALUES (?,?,?,?)";
    private static final String SQL_DELETE_BOOK_BY_ID = "DELETE FROM `book` WHERE `id` = ?";
    private static final String SQL_DELETE_BOOK_BY_PARAMS = "DELETE FROM `book` WHERE `title` = ? AND `author` = ? AND `publish_year` = ?";
    private static final String SQL_SELECT_BOOK_BY_ID = "SELECT * FROM `book` WHERE `id` = ?";
    private static final String SQL_UPDATE_BOOK_BY_ID = "UPDATE `book` SET `title` = ?,  `author` = ?, `brief` = ?, `publish_year` = ? WHERE `id` = ?";
    private static final String SQL_UPDATE_BOOK_TITLE = "UPDATE `book` SET `title` = ? WHERE `title` = ?";
    private static final String SQL_UPDATE_BOOK_TITLE_BY_REGEXP = "UPDATE `book` SET `title` = ? WHERE `title` REGEXP ?";

    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_AUTHOR = "author";
    private static final String COLUMN_BRIEF = "brief";
    private static final String COLUMN_PUBLISH_YEAR = "publish_year";

    public List<Book> selectAllBooks() throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_ALL_BOOKS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Book> bookList = new LinkedList<>();
            while (resultSet.next()) {
                Book book = new Book();
                book.setTitle(resultSet.getString(COLUMN_TITLE));
                book.setAuthor(resultSet.getString(COLUMN_AUTHOR));
                book.setBrief(resultSet.getString(COLUMN_BRIEF));
                book.setPublishYear(resultSet.getInt(COLUMN_PUBLISH_YEAR));
                bookList.add(book);
            }
            return bookList;
        } catch (SQLException e) {
            throw new DAOException("Error while selecting all books.", e);
        }
    }

    public Book selectBookById(int id) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_BOOK_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Book book = new Book();
            book.setTitle(resultSet.getString(COLUMN_TITLE));
            book.setAuthor(resultSet.getString(COLUMN_AUTHOR));
            book.setBrief(resultSet.getString(COLUMN_BRIEF));
            book.setPublishYear(resultSet.getInt(COLUMN_PUBLISH_YEAR));
            return book;
        } catch (SQLException e) {
            throw new DAOException("Error while selecting book by id", e);
        }
    }

    public void insertBook(String title, String author, String brief, int publishYear) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_INSERT_BOOK)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setString(3, brief);
            preparedStatement.setInt(4, publishYear);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Error while inserting new book.", e);
        }
    }

    public void deleteBookById(int id) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_DELETE_BOOK_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Error while deleting book by id.", e);
        }
    }

    public void deleteBookByParameters(String title, String author, int publishYear) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_DELETE_BOOK_BY_PARAMS)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setInt(3, publishYear);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Error while deleting book by parameters.", e);
        }
    }

    public void updateBookById(int id, String title, String author, String brief, int publishYear) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_UPDATE_BOOK_BY_ID)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setString(3, brief);
            preparedStatement.setInt(4, publishYear);
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Error while updating book by id.", e);
        }
    }

    public boolean updateBookTitle(String oldTitle, String newTitle) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_UPDATE_BOOK_TITLE)) {
            preparedStatement.setString(1, newTitle);
            preparedStatement.setString(2, oldTitle);
            int updatedRows = preparedStatement.executeUpdate();
            if (updatedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("Error while updating book title.", e);
        }
        return false;
    }

    public boolean updateBookTitleByMask(String titleMask, String newTitle) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_UPDATE_BOOK_TITLE_BY_REGEXP)) {
            preparedStatement.setString(1, newTitle);
            preparedStatement.setString(2, titleMask);
            int updatedRows = preparedStatement.executeUpdate();
            if (updatedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("Error while updating book title by mask.", e);
        }
        return false;
    }
}
