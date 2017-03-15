package com.epam.library.service;

import com.epam.library.command.CommandManager;
import com.epam.library.command.ICommand;
import com.epam.library.dao.BookDAO;
import com.epam.library.domain.Book;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BookService implements IService<Book> {
    private static final Logger LOG = LogManager.getLogger();

    @Override
    public List<Book> showAll() throws ServiceException {
        BookDAO bookDAO = new BookDAO();
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = bookDAO.selectAllBooks();
        } catch (DAOException e) {
            throw new ServiceException("Error while showing all books", e);
        }
        return bookList;
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
