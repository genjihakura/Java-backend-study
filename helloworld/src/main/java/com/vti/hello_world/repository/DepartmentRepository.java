package com.vti.hello_world.repository;

import com.vti.hello_world.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {
 Department findByDepartmentName(String departmentName);
 List<Department> findAllByDepartmentNameContains(String departmentName);
}
