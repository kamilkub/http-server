package org.http.request.reader;

import org.http.request.parts.Body;
import org.http.request.parts.RequestPart;

import java.util.List;

public class HttpBodyReader implements HttpReader {
    @Override
    public RequestPart read(List<String> requestLines) {
        Body body = new Body();
        body.setContent("");

        return body;
    }
}
