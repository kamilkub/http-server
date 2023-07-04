package org.http.request.reader;

import org.http.request.parts.Body;
import org.http.request.parts.RequestPart;

import java.util.List;
import java.util.stream.Collectors;

public class HttpBodyReader implements HttpReader {
    @Override
    public RequestPart read(List<String> requestLines) {
        Body body = new Body();

        StringBuilder plainBody = new StringBuilder();

        int startOfBody = requestLines.contains("\\s") ? requestLines.indexOf("\\s"): requestLines.indexOf("");

        while(startOfBody < requestLines.size() - 1) {
            plainBody.append(requestLines.get(startOfBody++));
        }

        body.setContent(plainBody.toString());

        return body;
    }
}
