package org.http.request;

import java.util.Stack;

public class Observable {

    public static final Stack<RequestListener> listeners = new Stack<>();


    public static void onRequestEvent() {
        if(!listeners.isEmpty()) {
            new Thread(listeners.pop());
        }
    }

}
