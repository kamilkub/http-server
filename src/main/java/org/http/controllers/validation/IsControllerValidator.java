package org.http.controllers.validation;

import org.http.annotations.HttpController;

public class IsControllerValidator {

    public static boolean validate(Object instance) {
        return instance.getClass().isAnnotationPresent(HttpController.class);
    }

}
