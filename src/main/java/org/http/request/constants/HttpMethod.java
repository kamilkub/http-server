package org.http.request.constants;

public enum HttpMethod {
    POST("POST"),
    PUT("PUT"),
    GET("GET"),
    DELETE("DELETE"),
    PATCH("PATCH");


    private final String value;

    HttpMethod(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }
}