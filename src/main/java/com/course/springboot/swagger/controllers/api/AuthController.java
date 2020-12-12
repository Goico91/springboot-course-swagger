package com.course.springboot.swagger.controllers.api;

import com.course.springboot.swagger.commons.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController implements AuthApi {

    @Override
    public ResponseEntity<Map> getToken() {
        Map response = new HashMap();
        response.put("token", Constants.AUTH_TOKEN);
        return ResponseEntity.ok().body(response);
    }
}
