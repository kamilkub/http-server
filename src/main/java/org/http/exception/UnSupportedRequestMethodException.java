package org.http.exception;

public class UnSupportedRequestMethodException extends Exception {

    private static final String EXCEPTION_MESSAGE = "Request method is not supported - ";

    public UnSupportedRequestMethodException(String httpMethod) {
        super(EXCEPTION_MESSAGE + httpMethod.trim());
    }

    public static void throwTestException() throws UnSupportedRequestMethodException {
            throw new UnSupportedRequestMethodException("TEST");
    }
}
