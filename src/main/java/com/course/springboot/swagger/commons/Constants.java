package com.course.springboot.swagger.commons;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Constants");
    }

    public static final String API_EMPLOYEES = "/employees";
    public static final String ID = "/{id}";

    public static final String OK_CODE_RESPONSE = "200";
    public static final String CREATED_CODE_RESPONSE = "201";
    public static final String UNAUTHORIZED_CODE_RESPONSE = "401";

    public static final String OK_RESPONSE = "OK";
    public static final String CREATED_RESPONSE = "Created";
    public static final String UNAUTHORIZED_RESPONSE = "Not Authorized";
}
