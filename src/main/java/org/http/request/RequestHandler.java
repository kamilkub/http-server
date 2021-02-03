package org.http.request;

import java.io.*;


public class RequestHandler {


    private static final RequestHandler INSTANCE = new RequestHandler();
    private StringBuilder requestPlainText = new StringBuilder();
    private InputStream clientInputStream;
    private OutputStream clientOutputStream;

    private RequestHandler() { }


    public void createHttpRequestObject() throws IOException {
        System.out.println("Creating Request...");

            BufferedReader reader = new BufferedReader(new InputStreamReader(this.clientInputStream));
            String line;
            while ((line = reader.readLine()) != null){
                requestPlainText.append(line + System.lineSeparator());
            }
            System.out.println(requestPlainText);

    }

    public StringBuilder getRequestPlainText() {
        return requestPlainText;
    }

    public void setClientInputStream(InputStream inputStream){
        this.clientInputStream = inputStream;
    }
    public void setClientOutputStream(OutputStream outputStream){
        this.clientOutputStream = outputStream;
    }



    public static synchronized RequestHandler getInstance(){
        return INSTANCE;
    }
}
