package org.http.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionsTest {


    @Test
    @DisplayName("UnSupportedRequestMethodException.class - TEST")
    void testThrowUnSupportedRequestException(){
        assertThrows(UnSupportedRequestMethodException.class, UnSupportedRequestMethodException::throwTestException);
    }


}
