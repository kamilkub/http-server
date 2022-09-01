package org.http.request;

import org.http.configuration.HttpRequestQueue;

public class RequestListener implements Listener {

    @Override
    public void run() {
        HttpRequest request = HttpRequestQueue.getAvailableRequest();



    }


}
