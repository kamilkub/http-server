package org.http.controllers.validation;

import org.http.annotations.RequestMapping;
import org.http.request.HttpRequest;
import org.http.response.HttpResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControllerMethodValidatorTest {

    @Test
    @DisplayName("should pass if method is incorrect")
    void validateIfMethodIsIncorrect() throws NoSuchMethodException {
        // given
        Method method = ControllerMethodValidatorTest.class.getMethod("incorrectMethod", Integer.class);
        // when
        IsControllerMethodValidator controllerMethodValidator = new IsControllerMethodValidator();
        boolean result = controllerMethodValidator.validate(method);
        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("should pass if method is correct")
    void validateIfMethodIsCorrect() throws NoSuchMethodException {
        // given
        Method method = ControllerMethodValidatorTest.class.getMethod(
                "correctMethod",
                HttpRequest.class,
                HttpResponse.class
        );
        // when
        IsControllerMethodValidator controllerMethodValidator = new IsControllerMethodValidator();
        boolean result = controllerMethodValidator.validate(method);
        // then
        assertTrue(result);
    }


    public String incorrectMethod(Integer integer) {
        return "";
    }

    @RequestMapping(method = "POST")
    public String correctMethod(HttpRequest request, HttpResponse response) {
        return "";
    }

}