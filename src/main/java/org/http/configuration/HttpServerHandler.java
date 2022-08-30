package org.http.configuration;


import org.http.handler.Dispatcher;
import org.http.handler.HttpDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

public class HttpServerHandler implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(HttpServerHandler.class);

    private final Socket clientSocket;

    private Dispatcher dispatcher;

    public HttpServerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.dispatcher = new HttpDispatcher();
    }

    @Override
    public void run() {

        try {
            dispatcher.accept(clientSocket.getInputStream(), clientSocket.getOutputStream());
          
        } catch (IOException e) {
            logger.error("Error while serving response.", e.getCause());
        }
    }
}
