package org.http.request.reader;

import org.http.request.parts.Body;
import org.http.request.parts.RequestPart;

import java.util.List;
import java.util.stream.Collectors;

public class HttpBodyReader implements HttpReader {
    @Override
    public RequestPart read(List<String> requestLines) {
        Body body = new Body();

        String [] headersBodySeparator =
                requestLines.stream().collect(Collectors.joining()).split("\n");

        body.setContent(headersBodySeparator.length > 0 ? headersBodySeparator[1] : "");

        return body;
    }
}
