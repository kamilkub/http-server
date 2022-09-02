package org.http.request.reader;

import org.http.request.parts.RequestPart;

import java.util.List;

public interface HttpReader {
    RequestPart read(List<String> requestLines);
}
