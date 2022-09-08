package org.http.request.constants;

public enum HttpRequestMethod {
    POST("POST"),
    PUT("PUT"),
    GET("GET"),
    DELETE("DELETE"),
    PATCH("PATCH"),
    NONE("");


    private final String value;

    HttpRequestMethod(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }
}