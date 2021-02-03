package org.http.configuration;

import org.http.request.RequestHandler;

import java.io.IOException;
import java.net.Socket;

public class HttpServerHandler implements Runnable {

    protected Socket clientSocket;


    public HttpServerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }


    @Override
    public void run() {

        String body = "\r\n\r\n<h1>Hello</h1>\r\n\r\n";
        try {
            RequestHandler requestHandler = RequestHandler.getInstance();
            requestHandler.setClientInputStream(clientSocket.getInputStream());
            requestHandler.createHttpRequestObject();
//            BufferedWriter httpResponse = new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()));
//            this.clientSocket.getOutputStream().write(
//                    ("HTTP/1.1 200 OK\r\n" +
//                    "Content-Length: " + body.length() +"\r\n" +
//                    "Connection: Closed\r\n" +
//                    "Content-Type: text/html\r\n" +
//                           body).getBytes());
//
//            this.clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
