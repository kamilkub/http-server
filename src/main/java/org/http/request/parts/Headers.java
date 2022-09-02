package org.http.request.parts;

import java.util.*;

public class Headers implements RequestPart {

    private final Set<Header> headers = new HashSet<>();

    public void addHeader(String headerName, String headerValue) {
        this.headers.add(new Header(headerName, headerValue));
    }

    public Set<Header> getAllHeaders() {
        return headers;
    }

    public Header getHeader(String name) {

        Iterator<Header> header = headers.iterator();

        while(header.hasNext()) {
            Header currentHeader = header.next();

            if(currentHeader.getName().equalsIgnoreCase(name)) {
                return currentHeader;
            }
        }

        return null;
    }

    public boolean hasHeader(String name) {
        return getHeader(name) != null;
    }

    public String getHeaderValue(String name) {
        Header header = getHeader(name);
        if(header == null) return null;

        return header.getValue();
    }

    public static class Header {
        private String name;
        private String value;

        public Header(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public Header() {}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
