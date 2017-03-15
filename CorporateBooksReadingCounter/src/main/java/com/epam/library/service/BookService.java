package com.epam.library.service;

import com.epam.library.dao.BookDAO;
import com.epam.library.domain.Book;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 *
 */
public class BookService implements IService<Book> {
    private static final Logger LOG = LogManager.getLogger();

    @Override
    public String showAll() throws ServiceException {
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList;
        StringBuffer bookListReport = new StringBuffer();
        try {
            bookList = bookDAO.selectAllBooks();
            bookList.forEach(b -> bookListReport.append(b).append("\n"));
        } catch (DAOException e) {
            throw new ServiceException("Error while showing all books", e);
        }
        return bookListReport.toString();
    }

    @Override
    public void insert(Book book) {
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public void showById(int id) {

    }

}
