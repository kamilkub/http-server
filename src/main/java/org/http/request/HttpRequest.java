package org.http.request;

public class HttpRequest {

    private HttpMethod httpMethod;
    private String HOST;
    private String USER_AGENT;
    private String ACCEPT;
    private String ACCEPT_LANGUAGE;
    private String ACCEPT_ENCODING;
    private String CONNECTION;


    public static class Builder {
        private HttpMethod bHttpMethod;
        private String bHOST;
        private String bUSER_AGENT;
        private String bACCEPT;
        private String bACCEPT_LANGUAGE;
        private String bACCEPT_ENCODING;
        private String bCONNECTION;

        public Builder httpMethod(HttpMethod httpMethod){
            this.bHttpMethod = httpMethod;
            return this;
        }

        public Builder host(String host){
            this.bHOST = host;
            return this;
        }

        public Builder userAgent(String userAgent){
            this.bUSER_AGENT = userAgent;
            return this;
        }

        public Builder acceptContent(String acceptContent){
            this.bACCEPT = acceptContent;
            return this;
        }

        public Builder acceptLanguage(String acceptLanguage){
            this.bACCEPT_LANGUAGE = acceptLanguage;
            return this;
        }

        public Builder acceptEncoding(String acceptEncoding){
            this.bACCEPT_ENCODING = acceptEncoding;
            return this;
        }

        public Builder connection(String connection){
            this.bCONNECTION = connection;
            return this;
        }

        public HttpRequest build(){
            HttpRequest httpRequest = new HttpRequest();
            httpRequest.ACCEPT = this.bACCEPT;
            httpRequest.httpMethod = this.bHttpMethod;
            httpRequest.ACCEPT_ENCODING = this.bACCEPT_ENCODING;
            httpRequest.ACCEPT_LANGUAGE = this.bACCEPT_LANGUAGE;
            httpRequest.CONNECTION = this.bCONNECTION;
            httpRequest.HOST = this.bHOST;
            httpRequest.CONNECTION = this.bCONNECTION;

            return httpRequest;
        }


    }


}
