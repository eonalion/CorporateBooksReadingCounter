package com.epam.library.command;


import com.epam.library.exception.ServiceException;
import com.epam.library.service.BookService;
import com.epam.library.service.EmployeeService;
import com.epam.library.service.ServiceFactory;
import com.epam.library.util.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class ViewCommand implements ICommand {
    private static final Logger LOG = LogManager.getLogger();

    @Override
    public Response execute(String params) {
        String reportString;
        Response response;
        try {
            switch (params) {
                case AvailableOperations.BOOKS_PARAM:
                    BookService bookService = ServiceFactory.getBookService();
                    response = bookService.showAll();
                    break;
                case AvailableOperations.EMPLOYEES_LONG_PARAM:
                case AvailableOperations.EMPLOYEES_SHORT_PARAM:
                    EmployeeService employeeService = ServiceFactory.getEmployeeService();
                    response = employeeService.showAll();
                    break;
                default:
                    response = new Response<String>();
                    response.setContent(AvailableOperations.INVALID_PARAMETER_LIST_MESSAGE);
            }
        } catch (ServiceException e) {
            LOG.error("Error while executing 'view' command", e);
            response = new Response<String>();
            response.setError(true);
            response.setContent(AvailableOperations.INVALID_PARAMETER_LIST_MESSAGE);
        }

        return response;
    }
}
