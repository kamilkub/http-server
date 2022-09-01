package org.http.response;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HttpResponse {

    private OutputStream outputStream;

    private HttpResponse () {}

    private static HttpResponse create(OutputStream outputStream) {
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setOutputStream(outputStream);

        return httpResponse;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void writeBody(String body) throws IOException {
        outputStream.write(String.format("Content-Length : %d", body.length()).getBytes(StandardCharsets.UTF_8));
        outputStream.write(String.format("\n %s", body).getBytes(StandardCharsets.UTF_8));
   }
}
