package org.http.request;

public class RequestUtils {


    public static HttpMethod getRequestMethod(String request){
        HttpMethod httpMethod = null;
        try{
            httpMethod = Enum.valueOf(HttpMethod.class, request.split("\\s")[0]);
        } catch (Exception e){
            e.printStackTrace();
        }

        return httpMethod;
    }


    // TODO: Method responsible for taking 'path' from HTTP request

    public static String getRequestPath(String request){
        return "";
    }

}
