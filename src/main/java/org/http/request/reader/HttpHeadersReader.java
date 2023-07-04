package org.http.request.reader;

import org.http.request.parts.Headers;
import org.http.request.parts.RequestPart;

import java.util.List;

public class HttpHeadersReader implements HttpReader {

    @Override
    public RequestPart read(List<String> requestLines) {
        Headers headers = new Headers();



        return headers;
    }
}
