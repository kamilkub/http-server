package org.http.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

public class HttpServerHandler implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(HttpServerHandler.class);
    private final Socket clientSocket;

    public HttpServerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try {
            /*
                TODO:
                    1. Pass I/O to class which checks requests' validity
             */
            clientSocket.getInputStream();
        } catch (IOException e) {
            logger.error("Error while serving response.", e.getCause());
        }
    }
}
