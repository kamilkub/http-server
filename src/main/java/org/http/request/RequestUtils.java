package org.http.request;

import org.http.exception.UnSupportedRequestMethodException;

public class RequestUtils {

    private RequestUtils() {}

    public static HttpMethod getRequestMethod(String request) throws UnSupportedRequestMethodException {
        HttpMethod httpMethod = null;
        String httpRequestText = request.split("\\s")[0];
        try{
            httpMethod = Enum.valueOf(HttpMethod.class, httpRequestText);
        } catch (Exception e){
            throw new UnSupportedRequestMethodException(httpRequestText);
        }

        return httpMethod;
    }


    // TODO: Method responsible for taking 'path' from HTTP request

    public static String getRequestPath(String request){
        return "";
    }

}
