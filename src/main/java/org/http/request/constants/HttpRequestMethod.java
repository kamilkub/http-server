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

    public static HttpRequestMethod[] allowedHttpMethods() {
        return new HttpRequestMethod[]{
                HttpRequestMethod.POST,
                HttpRequestMethod.PUT,
                HttpRequestMethod.GET,
                HttpRequestMethod.DELETE,
                HttpRequestMethod.PATCH,
                HttpRequestMethod.NONE
        };
    }
}