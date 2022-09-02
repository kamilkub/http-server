package org.http.request.reader;

import org.http.request.parts.Headers;
import org.http.request.parts.RequestPart;

import java.util.List;

public class HttpHeadersReader implements HttpReader {

    @Override
    public RequestPart read(List<String> requestLines) {
        Headers headers = new Headers();

//        requestLines.stream()
//                .filter(requestLine -> requestLine.contains(":"))
//                .map(requestLine -> requestLine.split(":"))
//                .filter(splitHeader -> splitHeader.length == HEADER_NAME_VALUE_LENGTH)
//                .collect(Collectors.toUnmodifiableList());

        return headers;
    }
}
