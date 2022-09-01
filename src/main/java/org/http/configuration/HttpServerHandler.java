package org.http.configuration;


import org.http.handler.Dispatcher;
import org.http.handler.HttpDispatcher;
import org.http.request.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;

public class HttpServerHandler implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(HttpServerHandler.class);

    private final Socket clientSocket;

    private Dispatcher dispatcher;

    public HttpServerHandler(Socket clientSocket, Dispatcher httpDispatcher) {
        this.clientSocket = clientSocket;
        this.dispatcher = httpDispatcher;
    }

    @Override
    public void run() {

//        try {
//            HttpRequest httpRequest = new HttpRequest()
//
//            dispatcher.accept();
//
//        } catch (IOException e) {
//            logger.error("Error while serving response.", e.getCause());
//        }
    }
}
