package com.vti.hello_world.service;

import com.vti.hello_world.entity.Department;
import com.vti.hello_world.modal.DepartmentCreateDto;
import com.vti.hello_world.modal.DepartmentSearchDto;
import com.vti.hello_world.modal.DepartmentUpdateDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DepartmentService {
    List<Department> getAll(String departmentName);

    Page<Department> search(DepartmentSearchDto request);

    Department create(DepartmentCreateDto department);

    Department update(DepartmentUpdateDto department);

    Department findById(int id);

    void deleteBy(int id);
}
