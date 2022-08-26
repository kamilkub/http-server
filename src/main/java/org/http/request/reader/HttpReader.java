package org.http.request.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface HttpReader {
    List<String> read(InputStream inputStream) throws IOException;
}
