package org.http.request;

import org.http.request.parts.Body;
import org.http.request.parts.Headers;
import org.http.request.parts.RequestLine;
import org.http.request.parts.RequestPart;
import org.http.request.reader.HttpBodyReader;
import org.http.request.reader.HttpReader;
import org.http.request.reader.HttpStreamReader;

import java.io.InputStream;
import java.util.List;

public class HttpRequestConverter {

    private final HttpStreamReader streamReader;

    private final List<HttpReader> httpReaders;

    public HttpRequestConverter(HttpStreamReader streamReader, List<HttpReader> httpReaderList) {
        this.streamReader = streamReader;
        this.httpReaders = httpReaderList;
    }

    public HttpRequest convert(InputStream inputStream) {
        List<String> requestLines = streamReader.read(inputStream);
        HttpRequest request = new HttpRequest();

        httpReaders.forEach(reader -> {
            RequestPart requestPart = reader.read(requestLines);

            Class<?> requestClazz = requestPart.getClass();

            if(requestClazz.isAssignableFrom(Body.class)) {
                request.setBody((Body) requestPart);
            } else if(requestClazz.isAssignableFrom(Headers.class)) {
                request.setHeaders((Headers) requestPart);
            } else if(requestClazz.isAssignableFrom(Headers.class)) {
                request.setRequestLine((RequestLine) requestPart);
            }
        });

        return request;
    }


}
