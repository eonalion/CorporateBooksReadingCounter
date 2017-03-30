package com.epam.library.command;

import com.epam.library.exception.ServiceException;
import com.epam.library.service.BookService;
import com.epam.library.service.ServiceFactory;
import com.epam.library.util.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class RenameBookCommand implements ICommand {
    private static final Logger LOG = LogManager.getLogger();
    private static final int MASK_OR_TITLE_INDEX = 0;
    private static final int OLD_TITLE_OR_MASK_INDEX = 1;
    private static final int NEW_TITLE_INDEX = 2;

    private static final String SUCCESS_MESSAGE = "Book was renamed to ";

    @Override
    public Response<String> execute(String params) {
        BookService bookService = ServiceFactory.getBookService();
        List<String> paramData = Arrays.asList(params.split(" ", 3));
        String responseString = "";
        boolean bookRenamed = true;

        Response<String> response = new Response<>();

        if (paramData.size() < 3) {
            return new Response<>(AvailableOperations.INVALID_PARAMETER_LIST_MESSAGE);
        }

        try {
            switch (paramData.get(MASK_OR_TITLE_INDEX)) {
                case AvailableOperations.MASK_PARAM:
                    bookRenamed = bookService.renameBook(paramData.get(OLD_TITLE_OR_MASK_INDEX), paramData.get(NEW_TITLE_INDEX), true);
                    responseString = SUCCESS_MESSAGE + paramData.get(NEW_TITLE_INDEX);
                    break;
                case AvailableOperations.TITLE_PARAM:
                    bookRenamed = bookService.renameBook(paramData.get(OLD_TITLE_OR_MASK_INDEX), paramData.get(NEW_TITLE_INDEX), false);
                    responseString = SUCCESS_MESSAGE + "\"" + paramData.get(NEW_TITLE_INDEX) + "\"";
                    break;
                default:
                    responseString = AvailableOperations.INVALID_PARAMETER_LIST_MESSAGE;
            }
            if (!bookRenamed) {
                responseString = AvailableOperations.INVALID_TITLE_MESSAGE;
            }
        } catch (ServiceException e) {
            LOG.error("Error while executing book rename operation.", e);
        }

        response.setContent(responseString);

        return response;
    }
}
