package com.qluser.service;

import com.qluser.dto.request.*;
import com.qluser.entity.Department;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAllDepartment();
    public Department getDepartmentById(int id);
    public Department createNewDepartment(DepartmentCreateRequestDto user);
    public Department updateDepartment(DepartmentUpdateRequestDto user);
    public void deleteDepartmentById(int id);
    public Page<Department> search(DepartmentSearchDto request);
}
