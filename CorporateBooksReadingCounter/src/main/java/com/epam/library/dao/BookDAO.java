package com.epam.library.dao;

import com.epam.library.domain.Book;
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
    private static final String SQL_INSERT_BOOK = "INSERT INTO `book`(`title`, `author`, `brief`, `publish_year`) VALUES (?,?,?)";
    private static final String SQL_DELETE_BOOK_BY_ID = "DELETE FROM `book` WHERE `id` = ?";
    private static final String SQL_DELETE_BOOK_BY_PARAMS = "DELETE FROM `book` WHERE `title` = ? AND `publish_year` = ? AND `author` = ?";
    private static final String SQL_SELECT_BOOK_BY_ID = "SELECT * FROM `book` WHERE `id` = ?";
    private static final String SQL_UPDATE_BOOK_BY_ID = "UPDATE `book` SET `title` = ?, `publish_year` = ?, `author` = ? WHERE `id` = ?";
    private static final String SQL_UPDATE_BOOK_TITLE = "UPDATE `book` SET `title` = ? WHERE `title` = ?";
    private static final String SQL_BOOK_TITLE_BY_MASK = "UPDATE `book` SET `title` = ? WHERE `title` LIKE ?";

    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_AUTHOR = "author";
    private static final String COLUMN_BRIEF = "brief";
    private static final String COLUMN_PUBLISH_YEAR = "publish_year";

    public List<Book> selectAllBooks() throws DAOException {
        try(PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_ALL_BOOKS)){
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
            throw new DAOException("Error while selecting all books" + e);
        }
    }

    public void insertBook(String title, String author, String brief) {
        try(PreparedStatement preparedStatement =  getConnection().prepareStatement(SQL_INSERT_BOOK)) {

        } catch (SQLException e) {

        }
    }

    public void deleteBookById(int id) {}

    public void deleteBookByParams(String title, String author, String brief) {}

    //public Book selectBookById(int id) {}

    public void updateBookById(int id, String title, String author, int publishYear) {}

    public void updateBookTitle(int id, String title) {}

    public void updateBookTitleByMask (int id, String mask) {}
}
