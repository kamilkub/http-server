package org.http.request;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class HttpRequestTest {

    @Test
    @DisplayName("Should throw an exception if http request data is empty")
    public void shouldThrowAnExceptionIfRequestDataIsEmpty() {
        assertThrows(InvalidHttpRequestException.class, () -> new HttpRequest(Collections.emptyList()));
    }

    @Test
    @DisplayName("Should throw an exception if http request headers are empty")
    public void shouldThrowAnExceptionIfHeadersEmpty() {
        String request = "GET /home HTTP/1.1";
        assertThrows(InvalidHttpRequestException.class, () -> new HttpRequest(Collections.singletonList(request)));
    }

    @Test
    @DisplayName("Should contain two headers")
    public void shouldContainTwoHeaders() throws InvalidHttpRequestException {
        String request = "GET /home HTTP/1.1\nContent-Type: text/html\nAccept: img/jpeg";
        assertEquals(2, new HttpRequest(List.of(request.split("\n"))).headersCount());
    }
}