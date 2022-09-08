package org.http.request.reader;

import org.http.request.constants.HttpRequestMethod;
import org.http.request.parts.RequestLine;
import org.http.request.parts.RequestPart;

import java.util.Arrays;
import java.util.List;

public class HttpRequestLineReader implements HttpReader {

    @Override
    public RequestPart read(List<String> requestLines) {
        RequestLine requestPart = new RequestLine();

        String reqFirstLine = requestLines.get(0);

        HttpRequestMethod reqMethod = findRequestMethod(reqFirstLine);
        String requestPath = findRequestPath(reqFirstLine);

        requestPart.setHttpMethod(reqMethod);
        requestPart.setRequestPath(requestPath);

        return requestPart;
    }

    private String findRequestPath(String requestLine) {
        int firstSlashIdx = requestLine.indexOf("\\");
        return requestLine.substring(firstSlashIdx).replaceAll("\\s+", "");
    }

    private HttpRequestMethod findRequestMethod(String requestLine) {
        return Arrays.stream(HttpRequestMethod.values())
                .filter(method -> requestLine.toLowerCase().contains(method.getValue().toLowerCase()))
                .findFirst().orElse(HttpRequestMethod.NONE);
    }
}
