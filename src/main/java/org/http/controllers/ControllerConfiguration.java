package org.http.controllers;

import org.http.annotations.RequestMapping;
import org.http.request.HttpRequest;
import org.http.request.constants.HttpMethod;
import org.http.response.HttpResponse;

import java.lang.reflect.Method;

public class ControllerConfiguration {


    private static boolean hasCorrectAnnotationValues(Method method, HttpMethod httpMethod) {
        RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);

        return requestMapping.method().equalsIgnoreCase(httpMethod.getValue());
    }

    private static boolean hasCorrectAnnotation(Method method) {
        return method.isAnnotationPresent(RequestMapping.class);
    }

    private static boolean hasCorrectParams(Method method) {
        Class<?> paramTypes [] = method.getParameterTypes();

        boolean hasReqParam = false;
        boolean hasRespParam = false;

        for(Class paramType : paramTypes) {
            if(hasReqParam && hasRespParam) break;

            if(paramType.isInstance(HttpRequest.class)) {
                hasReqParam = true;
            }

            if(paramType.isInstance(HttpResponse.class)) {
                hasRespParam = true;
            }
        }

        return hasReqParam && hasRespParam;
    }

}
