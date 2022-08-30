package org.http.request;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RequestUtils {

    private static final Logger logger = LoggerFactory.getLogger(RequestUtils.class);

    public static HttpRequest build(List<String> packetLInes) {
        return new HttpRequest.Builder()
                .build();
    }

    private static String retrieveContentType(List<String> packetLines) {
        return packetLines
                .stream()
                .filter(packetLine -> packetLine.startsWith(HttpStandardHeaders.CONTENT_TYPE.val()))
                .findFirst()
                .orElse("");
    }

    /**
     *  Because every HTTP Request starts with method type and path, we have to look at the first line
     */
    private static String retrieveRequestPath(List<String> packetLines) {
        String firstPacketLine = packetLines.get(0);
        String [] separatedLine = firstPacketLine.split("\\s");

        return separatedLine[1].replaceAll("\\s", "");
    }

    private static String getRequestPath(List<String> packetLines) {
        String firstPacketLine = packetLines.get(0);
        String [] separatedLine = firstPacketLine.split("\\s");

        return separatedLine[1].replaceAll("\\s", "");
    }

}