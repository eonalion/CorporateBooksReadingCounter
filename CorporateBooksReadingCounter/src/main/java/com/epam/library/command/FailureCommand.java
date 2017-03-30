package com.epam.library.command;

import com.epam.library.util.Response;

/**
 *
 */
public class FailureCommand implements ICommand {
    private String failureMessage;

    public FailureCommand(String message) {
        this.failureMessage = message;
    }

    @Override
    public Response<String> execute(String params) {
        Response<String> response = new Response<>();
        response.setError(true);
        response.setContent(failureMessage);
        return response;
    }
}
