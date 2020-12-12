package com.course.springboot.swagger.controllers.mappers;

import com.course.springboot.swagger.controllers.dto.EmployeeDTO;
import com.course.springboot.swagger.vo.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {EmployeeKnowledgeToEmployeeKnowledgeDTO.class})
public interface EmployeeToEmployeeDTOMapper {

    EmployeeToEmployeeDTOMapper INSTANCE = Mappers.getMapper(EmployeeToEmployeeDTOMapper.class);

    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    Employee employeeDTOToEmployee(EmployeeDTO employee);
}
