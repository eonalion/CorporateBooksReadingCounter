package com.epam.library.service;

import com.epam.library.dao.BookDAO;
import com.epam.library.dao.DAOFactory;
import com.epam.library.entity.Book;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;
import com.epam.library.util.Response;
import java.util.List;

/**
 *
 */
public class BookService {
    public Response<List<Book>> showAll() throws ServiceException {
        BookDAO bookDAO = DAOFactory.getBookDAO();
        Response<List<Book>> response = new Response<>();
        List<Book> bookList;
        try {
            bookList = bookDAO.selectAllBooks();
            response.setContent(bookList);
        } catch (DAOException e) {
            throw new ServiceException("Error while showing all books", e);
        }
        return response;
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
