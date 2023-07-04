package org.http.request;

import org.http.request.reader.HttpBodyReader;
import org.http.request.reader.HttpHeadersReader;
import org.http.request.reader.HttpRequestLineReader;
import org.http.request.reader.HttpStreamReader;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

class HttpRequestConverterTest {


    @Test
    public void test() {
        HttpRequestConverter requestConverter = new HttpRequestConverter(
                new HttpStreamReader(),
                List.of(new HttpBodyReader(), new HttpRequestLineReader(), new HttpHeadersReader())
        );

        StringBuilder request = new StringBuilder();
        request.append("GET /home HTTP 1.1\n");
        request.append("Content-Type: application/json\n");
        request.append("\n");
        request.append("username=ala&password=testjhgkjhgkjgkjgkgkjgkjgkjgkjgkjgkjgkjsdfgsdfgsdfgsdfg" +
                "sdfgsdfgsdfgsdfgsdfgsd" +
                "sdfgsdfgsdfgsdfgs");

        requestConverter.convert(new ByteArrayInputStream(request.toString().getBytes(StandardCharsets.UTF_8)));


    }


}