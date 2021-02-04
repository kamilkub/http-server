package org.http.request;


import org.http.exception.UnSupportedRequestMethodException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RequestUtilsTest {

    private static final String SAMPLE_REQUEST = "POST / HTTP/1.1\n" +
            "Host: localhost:8080\n" +
            "Connection: keep-alive\n" +
            "Upgrade-Insecure-Requests: 1\n" +
            "User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.104 Safari/537.36\n" +
            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\n" +
            "Sec-Fetch-Site: none\n" +
            "Sec-Fetch-Mode: navigate\n" +
            "Sec-Fetch-User: ?1\n" +
            "Sec-Fetch-Dest: document\n" +
            "Accept-Encoding: gzip, deflate, br\n" +
            "Accept-Language: pl-PL,pl;q=0.9,en-US;q=0.8,en;q=0.7";


    @Test
    @DisplayName(value = "Testing getRequestMethod() from RequestUtils.class")
    void testGetRequestMethod() throws UnSupportedRequestMethodException {
        // when
        HttpMethod requestMethod = RequestUtils.getRequestMethod(SAMPLE_REQUEST);

        // then
        assertEquals(HttpMethod.POST, requestMethod);
        assertThrows(UnSupportedRequestMethodException.class, () -> RequestUtils.getRequestMethod("INFO"));

    }

    @Test
    @DisplayName(value = "Testing getRequestPath() from RequestUtils.class")
    void testGetRequestPath() { }

}