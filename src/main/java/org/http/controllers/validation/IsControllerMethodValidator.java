package org.http.controllers.validation;

import org.http.annotations.RequestMapping;
import org.http.request.HttpRequest;
import org.http.request.constants.HttpRequestMethod;
import org.http.response.HttpResponse;

import java.lang.reflect.Method;
import java.util.Arrays;

public class IsControllerMethodValidator {

    public static boolean validate(Method method) {
        return hasCorrectAnnotation(method)
                && hasCorrectRequestMethodType(method)
                && hasCorrectParams(method);
    }

    private static boolean hasCorrectAnnotation(Method method) {
        return method.isAnnotationPresent(RequestMapping.class);
    }

    private static boolean hasCorrectRequestMethodType(Method method) {
        RequestMapping methodRequestType = method.getAnnotation(RequestMapping.class);

        return Arrays.stream(HttpRequestMethod.allowedHttpMethods())
                .anyMatch(allowedMethod -> methodRequestType.method().equalsIgnoreCase(allowedMethod.getValue()));
    }

    private static boolean hasCorrectParams(Method method) {
        Class<?>[] paramTypes = method.getParameterTypes();

        boolean hasReqParam = false;
        boolean hasRespParam = false;

        for (Class<?> paramType : paramTypes) {
            if (hasReqParam && hasRespParam) break;

            if (paramType.isAssignableFrom(HttpRequest.class)) {
                hasReqParam = true;
            }

            if (paramType.isAssignableFrom(HttpResponse.class)) {
                hasRespParam = true;
            }
        }

        return hasReqParam && hasRespParam;
    }


}
