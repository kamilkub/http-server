package org.http.request;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class RequestUtils {

    private static final Logger logger = LoggerFactory.getLogger(RequestUtils.class);

    public static HttpRequest build(InputStream inputStream) throws IOException {
        String [] plainPacket = readPacket(inputStream);

        return new HttpRequest.Builder()
                .requestPath(retrieveRequestPath(plainPacket))
                .build();
    }

    // TODO: Method should get content type of request
    private static String retrieveContentType(String [] plainPacket) {
        return null;
    }

    // TODO: Method should get resource path of request
    private static String retrieveRequestPath(String [] plainPacket) {
        return null;
    }

    private static String[] readPacket(InputStream inputStream) throws IOException {
        return new String(inputStream.readAllBytes()).split("\n");
    }

}