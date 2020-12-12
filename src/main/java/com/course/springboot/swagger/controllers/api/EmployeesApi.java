package com.course.springboot.swagger.controllers.api;

import com.course.springboot.swagger.commons.Constants;
import com.course.springboot.swagger.config.error.RestException;
import com.course.springboot.swagger.controllers.dto.EmployeeDTO;
import com.course.springboot.swagger.controllers.dto.ListEmployeesDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * API for Employees Services
 */
@RequestMapping(value = Constants.API_EMPLOYEES)
public interface EmployeesApi {

    @Operation(description = "Get all employees")
    @ApiResponses( value = {
            @ApiResponse(responseCode = Constants.OK_CODE_RESPONSE, description = Constants.OK_RESPONSE),
            @ApiResponse(responseCode = Constants.UNAUTHORIZED_CODE_RESPONSE, description = Constants.UNAUTHORIZED_RESPONSE)
    })
    @GetMapping
    ResponseEntity<List<ListEmployeesDTO>> getEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) Integer office,
            Pageable pageable);

    @Operation(description = "Get detail from one employee")
    @ApiResponses( value = {
            @ApiResponse(responseCode = Constants.OK_CODE_RESPONSE, description = Constants.OK_RESPONSE),
            @ApiResponse(responseCode = Constants.UNAUTHORIZED_CODE_RESPONSE, description = Constants.UNAUTHORIZED_RESPONSE)
    })
    @GetMapping(Constants.ID)
    ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int id) throws RestException;

    @Operation(description = "Create new employee")
    @ApiResponses( value = {
            @ApiResponse(responseCode = Constants.CREATED_CODE_RESPONSE, description = Constants.CREATED_RESPONSE),
            @ApiResponse(responseCode = Constants.UNAUTHORIZED_CODE_RESPONSE, description = Constants.UNAUTHORIZED_RESPONSE)
    })
    @PostMapping
    ResponseEntity<Void> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws RestException;

    @Operation(description = "Update existing employee")
    @PutMapping(Constants.ID)
    ResponseEntity<Void> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeeDTO employeeDTO) throws RestException;

    @Operation(description = "Delete existing employee")
    @DeleteMapping(Constants.ID)
    ResponseEntity<Void> deleteEmployee(@PathVariable int id) throws RestException;
}
