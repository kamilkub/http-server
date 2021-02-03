package org.http.configuration;

import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer implements Runnable {


    protected int port = 8080;
    protected boolean isStopped = false;
    protected ServerSocket serverSocket = null;
    protected Thread runningThread = null;

    public HttpServer(int port) {
        this.port = port;
    }


    public static void runServer(int port){
        new HttpServer(port).run();
    }

    @Override
    public void run() {

        synchronized (this){
            this.runningThread = Thread.currentThread();
        }

        openServerSocket();

        while(!isStopped()){
            Socket clientSocket = null;

            try{
                clientSocket = serverSocket.accept();

            }catch (Exception e){
                if(isStopped()){
                    System.out.println("Server stopped.");
                }
                throw new RuntimeException("Error with connection", e);
            }

            new Thread(new HttpServerHandler(clientSocket)).start();

        }
    }


    private synchronized boolean isStopped(){
        return this.isStopped;
    }

    private void openServerSocket(){
        try{
            serverSocket = new ServerSocket(this.port);
        }catch (Exception e){
            throw new RuntimeException("Error opening server on " + this.port + " port", e);
        }
    }



}
