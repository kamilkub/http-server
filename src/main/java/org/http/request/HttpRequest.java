package org.http.request;

public class HttpRequest {

    private HttpMethod httpMethod;
    private String requestPath;
    private String host;
    private String userAgent;
    private String accept;
    private String acceptLanguage;
    private String acceptEncoding;
    private String connection;


    public static class Builder {
        private HttpMethod bHttpMethod;
        private String bRequestPath;
        private String bHost;
        private String bUserAgent;
        private String bAccept;
        private String bAcceptLanguage;
        private String bAcceptEncoding;
        private String bConnection;

        public Builder httpMethod(HttpMethod httpMethod){
            this.bHttpMethod = httpMethod;
            return this;
        }

        public Builder host(String host){
            this.bHost = host;
            return this;
        }

        public Builder requestPath(String requestPath){
            this.bRequestPath = requestPath;
            return this;
        }



        public Builder userAgent(String userAgent){
            this.bUserAgent = userAgent;
            return this;
        }

        public Builder acceptContent(String acceptContent){
            this.bAccept = acceptContent;
            return this;
        }

        public Builder acceptLanguage(String acceptLanguage){
            this.bAcceptLanguage = acceptLanguage;
            return this;
        }

        public Builder acceptEncoding(String acceptEncoding){
            this.bAcceptEncoding = acceptEncoding;
            return this;
        }

        public Builder connection(String connection){
            this.bConnection = connection;
            return this;
        }

        public HttpRequest build(){
            HttpRequest httpRequest = new HttpRequest();
            httpRequest.accept = this.bAccept;
            httpRequest.userAgent = this.bUserAgent;
            httpRequest.httpMethod = this.bHttpMethod;
            httpRequest.acceptEncoding = this.bAcceptEncoding;
            httpRequest.acceptLanguage = this.bAcceptLanguage;
            httpRequest.connection = this.bConnection;
            httpRequest.host = this.bHost;
            httpRequest.requestPath = this.bRequestPath;

            return httpRequest;
        }

    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public String getHost() {
        return host;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getAccept() {
        return accept;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public String getConnection() {
        return connection;
    }
}
