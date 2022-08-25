package org.http.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(HttpServer.class);
    private static final int PORT = 8080;
    private int customPort = 0;
    private boolean isStopped = false;
    private ServerSocket serverSocket = null;
    private final ExecutorService executorService = Executors.newScheduledThreadPool(20);

    public HttpServer(int port) {
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
                executorService.submit(new HttpServerHandler(clientSocket));
            }

        } catch (IOException e) {
            logger.error("Error with connection, shutting down... ", e.getCause());
        }
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    private synchronized void stop() {
        this.isStopped = true;
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