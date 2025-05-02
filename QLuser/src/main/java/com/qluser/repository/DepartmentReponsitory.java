package com.qluser.repository;

import com.qluser.entity.Department;
import com.qluser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartmentReponsitory extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {

}
