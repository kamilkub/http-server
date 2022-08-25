package org.http.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

public class HttpServerHandler implements Runnable {

    private final Socket clientSocket;
    private final Logger logger = LoggerFactory.getLogger(HttpServerHandler.class);

    public HttpServerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try {
            clientSocket.getInputStream();

        } catch (IOException e) {
            logger.error("Error while serving response.", e.getCause());
        }
    }
}
