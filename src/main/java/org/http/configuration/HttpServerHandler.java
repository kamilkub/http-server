package org.http.configuration;

import org.http.request.RequestHandler;

import java.io.IOException;
import java.net.Socket;

public class HttpServerHandler implements Runnable {

    protected Socket clientSocket = null;


    public HttpServerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }


    @Override
    public void run() {
        try {
            RequestHandler requestHandler = RequestHandler.getInstance();
            requestHandler.setClientInputStream(clientSocket.getInputStream());
            requestHandler.createHttpRequestObject();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
