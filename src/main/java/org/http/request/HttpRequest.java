package org.http.request;


import org.http.request.parts.Body;
import org.http.request.parts.Headers;
import org.http.request.parts.RequestLine;

public class HttpRequest {

    private RequestLine requestLine;
    private Headers headers;
    private Body body;


    public RequestLine getRequestLine() {
        return requestLine;
    }

    public void setRequestLine(RequestLine requestLine) {
        this.requestLine = requestLine;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}