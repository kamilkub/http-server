package org.http.request;

import org.http.exception.InvalidHttpRequestException;
import org.http.request.constants.HttpMethod;
import org.http.request.constants.HttpStandardHeaders;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpRequest {

    private Map<String, String> collectedHeaders;

    private static final int HEADER_NAME_VALUE_LENGTH = 2;

    private HttpMethod httpMethod;

    private String requestPath;


    private HttpRequest() {}

    public HttpRequest(List<String> packetLines) throws InvalidHttpRequestException {

        if (packetLines.isEmpty()) {
            throw new InvalidHttpRequestException();
        }

        HttpMethod httpMethod = collectHttpMethod(packetLines);

        assert httpMethod != null;

        this.collectedHeaders = collectHeaders(packetLines);
        this.httpMethod = httpMethod;
    }

    public int headersCount() {
        return collectedHeaders.size();
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    private Map<String, String> collectHeaders(List<String> requestLines) throws InvalidHttpRequestException {

        List<String[]> headers = collectHeaderPretenders(requestLines);
        List<String[]> validHeaders = collectValidHeaders(headers);


        if (validHeaders.isEmpty()) {
            throw new InvalidHttpRequestException();
        }

        Map<String, String> headersHolder = new HashMap<>();

        validHeaders.forEach(headersKV -> {
            String hName = headersKV[0];
            String hValue = headersKV[1];
            headersHolder.put(hName, hValue);
        });

        return headersHolder;
    }

    private List<String[]> collectHeaderPretenders(List<String> requestLines) {
        return requestLines.stream()
                .filter(requestLine -> requestLine.contains(":"))
                .map(requestLine -> requestLine.split(":"))
                .filter(splitHeader -> splitHeader.length == HEADER_NAME_VALUE_LENGTH)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<String[]> collectValidHeaders(List<String[]> headersKeyValue) {
        return headersKeyValue.stream()
                .filter(splitHeader -> Arrays.stream(HttpStandardHeaders.values())
                        .anyMatch(headerName -> headerName.val().equalsIgnoreCase(splitHeader[0])))
                .collect(Collectors.toUnmodifiableList());
    }

    private HttpMethod collectHttpMethod(List<String> requestLines) {
        String httpRequestBegin = requestLines.get(0).toLowerCase();

        return Arrays.stream(HttpMethod.values())
                .filter(httpMethod -> httpRequestBegin.contains(httpMethod.getValue().toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    private String collectRequestPath() {
        return "";
    }
}