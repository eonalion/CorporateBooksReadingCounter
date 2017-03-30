package com.epam.library.command;

import com.epam.library.util.Response;

/**
 *
 */
public class ExitCommand implements ICommand {

    @Override
    public Response<String> execute(String command) {
        Response<String> response = new Response<>();
        response.setContent(AvailableOperations.EXIT_MESSAGE);
        return response;
    }
}
