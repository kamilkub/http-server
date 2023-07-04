package org.http.configuration;

import org.http.request.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(HttpServer.class);

    private static final int PORT = 8080;

    private ServerSocket serverSocket = null;

    private int customPort = 0;

    private volatile static boolean isStopped = false;


    HttpServer(int port) {
        this.customPort = port;
    }

    public static void runServer(int port) {
        new HttpServer(port).run();
    }

    public static void runServer() {
        runServer(PORT);
    }

    @Override
    public void run() {
        openServerSocket(this.customPort);

        try {

            while (!isStopped()) {
                Socket clientSocket = serverSocket.accept();
                HttpRequest httpRequest = new HttpRequest();
            }

        } catch (IOException e) {
            logger.error("Error with connection, shutting down... ", e.getCause());
        }
    }

    private synchronized boolean isStopped() {
        return isStopped;
    }

    private static synchronized void stop() {
        isStopped = true;
    }

    private void openServerSocket(int port) {
        try {
            int chosenPort = port != 0 ? port : PORT;
            this.serverSocket = new ServerSocket(chosenPort);
        } catch (IOException e) {
            logger.error("Error opening server on ", e.getCause());
        }
    }
}