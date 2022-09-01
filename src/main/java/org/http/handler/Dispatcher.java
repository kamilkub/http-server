package org.http.handler;

import org.http.request.HttpRequest;
import org.http.response.HttpResponse;

import java.io.InputStream;
import java.io.OutputStream;

public interface Dispatcher {
    void accept(HttpRequest request, HttpResponse response);
}
