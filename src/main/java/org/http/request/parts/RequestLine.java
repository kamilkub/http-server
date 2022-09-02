package org.http.request.parts;

import org.http.request.constants.HttpRequestMethod;

public class RequestLine implements RequestPart{

    private HttpRequestMethod httpMethod;
    private String requestPath;

    public HttpRequestMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpRequestMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }
}
