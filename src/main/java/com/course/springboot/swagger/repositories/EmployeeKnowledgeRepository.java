package com.course.springboot.swagger.repositories;

import com.course.springboot.swagger.vo.EmployeeKnowledge;
import com.course.springboot.swagger.vo.EmployeeKnowledgeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeKnowledgeRepository extends JpaRepository<EmployeeKnowledge, EmployeeKnowledgeKey> {

}
