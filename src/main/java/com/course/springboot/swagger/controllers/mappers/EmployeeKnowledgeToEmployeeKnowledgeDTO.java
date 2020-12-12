package com.course.springboot.swagger.controllers.mappers;

import com.course.springboot.swagger.controllers.dto.EmployeeKnowledgeDTO;
import com.course.springboot.swagger.vo.EmployeeKnowledge;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeKnowledgeToEmployeeKnowledgeDTO {

    EmployeeKnowledge toEmployeeKnowledge(EmployeeKnowledgeDTO employeeKnowledgeDTO);

    EmployeeKnowledgeDTO toEmployeeKnowledgeDTO(EmployeeKnowledge employeeKnowledge);
}
