package com.epam.library.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class CLIReaderWriter {
    private static final Logger LOG = LogManager.getLogger();

    private CLIReaderWriter(){}

    public static Request read() {
        Request request = new Request();
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            LOG.info("Input:");
            String input = bufferRead.readLine();
            input = input.trim();
            int delimiter = input.indexOf(' ');
            String commandString = null;
            String paramString = "";
            if (delimiter > 0) {
                commandString = input.substring(0, delimiter).trim();
                paramString = input.substring(delimiter).trim();
            } else if (!input.isEmpty()) {
                commandString = input;
            }

            request.setCommand(commandString);
            request.setParameters(paramString);
        } catch (IOException e) {
            LOG.fatal("Error while reading from console", e);
            throw new RuntimeException(e);
        }
        return request;
    }

    public static void write(Response response) {
        if(response.isError()) {
            LOG.info("Error:");
        }
        System.out.println(response.getContent());
    }
}
