package org.http.configuration;

import org.http.request.HttpRequest;

import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class HttpRequestQueue extends SynchronousQueue<HttpRequest> implements Queue<HttpRequest> {

    private static final HttpRequestQueue INSTANCE = new HttpRequestQueue();

    private HttpRequestQueue () {}

    public static void addRequest(HttpRequest request) {
        INSTANCE.add(request);
    }

    public static HttpRequest getAvailableRequest() {
        return INSTANCE.poll();
    }

}