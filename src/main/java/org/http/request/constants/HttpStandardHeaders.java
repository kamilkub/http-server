package org.http.request.constants;

public enum HttpStandardHeaders {

    AIM("A-IM"),
    ACCEPT("Accept"),
    ACCEPT_CHARSET("Accept-Charset"),
    ACCEPT_ENCODING("Accept-Encoding"),
    ACCEPT_LANGUAGE("Accept-Language"),
    ACCEPT_DATETIME("Accept-Datetime"),
    ACCESS_CONTROL_REQUEST_METHOD("Access-Control-Request-Method"),
    ACCESS_CONTROL_REQUEST_HEADERS("Access-Control-Request-Headers"),
    AUTHORIZATION("Authorization"),
    CACHE_CONTROL("Cache-Control"),
    CONNECTION("Connection"),
    CONTENT_LENGTH("Content-Length"),
    CONTENT_TYPE("Content-Type"),
    COOKIE("Cookie"),
    DATE("Date"),
    EXPECT("Expect"),
    FORWARDED("Forwarded"),
    FROM("From"),
    HOST("Host"),
    IF_MATCH("If-Match"),
    IF_MODIFIED_SINCE("If-Modified-Since"),
    IF_NONE_MATCH("If-None-Match"),
    IF_RANGE("If-Range"),
    IF_UNMODIFIED_SINCE("If-Unmodified-Since"),
    MAX_FORWARDS("Max-Forwards"),
    ORIGIN("Origin"),
    PRAGMA("Pragma"),
    PROXY_AUTHORIZATION("Proxy-Authorization"),
    RANGE("Range"),
    REFERER("Referer"),
    TE("Te"),
    USER_AGENT("User-Agent"),
    UPGRADE("Upgrade"),
    VIA("Via"),
    WARNING("Warning");

    private final String value;

    HttpStandardHeaders(String value) {
        this.value = value;
    }

    public String val() {
        return this.value;
    }
}
