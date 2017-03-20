package com.epam.library.service;

import com.epam.library.dao.BookDAO;
import com.epam.library.dao.DAOFactory;
import com.epam.library.domain.Book;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class BookService {
    private static final Logger LOG = LogManager.getLogger();
    public String showAll() throws ServiceException {
        BookDAO bookDAO = DAOFactory.getBookDAO();
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

    public boolean renameBook(String titleOrMask, String newTitle, boolean byMask) throws ServiceException {
        BookDAO bookDAO = DAOFactory.getBookDAO();
        boolean updateResult = false;
        try {
            if (byMask) {
                updateResult = bookDAO.updateBookTitleByMask(titleOrMask, newTitle);
            } else {
                updateResult = bookDAO.updateBookTitle(titleOrMask, newTitle);
            }
        } catch (DAOException e) {
            throw new ServiceException("Error while rename book", e);
        }
        return updateResult;
    }

}
