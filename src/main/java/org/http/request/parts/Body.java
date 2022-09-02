package org.http.request.parts;

public class Body implements RequestPart {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isEmpty() {
        return this.content.replace("\\s", "").isEmpty();
    }
}
