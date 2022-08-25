package org.http.handler;

import java.io.InputStream;
import java.io.OutputStream;

public interface Dispatcher {
    void accept(InputStream stream, OutputStream outputStream);
}
