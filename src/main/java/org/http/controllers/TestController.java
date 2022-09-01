package org.http.controllers;

import org.http.annotations.RequestMapping;
import org.http.request.HttpRequest;
import org.http.response.HttpResponse;

public class TestController {


    @RequestMapping(method = "GET")
    public void homePage (HttpRequest request, HttpResponse response) {

    }

}
