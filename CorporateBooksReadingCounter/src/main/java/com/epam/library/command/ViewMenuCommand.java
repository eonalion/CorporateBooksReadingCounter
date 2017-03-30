package com.epam.library.command;

import com.epam.library.util.Response;

import java.util.Map;

/**
 *
 */
public class ViewMenuCommand implements ICommand {
    @Override
    public Response<String> execute(String param) {
        Response<String> response = new Response<>();
        String responseString;
        if (param.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            Map<String, ICommand> commands = CommandManager.getCommands();
            commands.forEach((s, c) -> {
                        builder.append(s);
                        if(CommandManager.getParameters().containsKey(s)) {
                            builder.append("\t");
                            CommandManager.getParameters().get(s).forEach(p ->builder.append("[ " +p+ " ]"));
                        }
                        builder.append("\n");
                    }
            );
            responseString = builder.toString();
        } else {
            response.setError(true);
            responseString = AvailableOperations.INVALID_PARAMETER_LIST_MESSAGE;
        }

        response.setContent(responseString);

        return response;
    }
}
