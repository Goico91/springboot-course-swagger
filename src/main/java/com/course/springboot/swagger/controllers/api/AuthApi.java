package com.course.springboot.swagger.controllers.api;

import com.course.springboot.swagger.commons.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping(Constants.API_AUTH)
public interface AuthApi {

    @GetMapping
    ResponseEntity<Map> getToken();
}
