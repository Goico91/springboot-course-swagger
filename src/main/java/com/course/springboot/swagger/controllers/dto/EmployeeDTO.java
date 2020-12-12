package com.course.springboot.swagger.controllers.dto;

import com.course.springboot.swagger.vo.Office;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class EmployeeDTO implements Serializable {

    @ApiModelProperty(value = "Name of the Employee", required = true, example = "Carlos")
    @NotNull(message = "Name can not be null")
    private String name;

    @ApiModelProperty(value = "Surname of the Employee", required = true, example = "Goicoechea")
    @NotBlank(message = "Surname can not be null")
    private String surname;

    @ApiModelProperty(value = "Password of the Employee", required = true, example = "prueba")
    @NotBlank(message = "Password can not be null")
    private String password;

    @Min(value = 18, message = "Min age is 18 years")
    @Max(value = 100, message = "Max age is 100 years")
    private Integer age;

    @NotNull(message = "Office can not be null")
    private Office office;

    private List<EmployeeKnowledgeDTO> employeeKnowledge;

    public EmployeeDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public List<EmployeeKnowledgeDTO> getEmployeeKnowledge() {
        return employeeKnowledge;
    }

    public void setEmployeeKnowledge(List<EmployeeKnowledgeDTO> employeeKnowledge) {
        this.employeeKnowledge = employeeKnowledge;
    }
}
