package com.qluser.service.Impl;

import com.qluser.dto.request.*;
import com.qluser.entity.Department;
import com.qluser.repository.DepartmentReponsitory;
import com.qluser.repository.specification.DepartmentSpecification;
import com.qluser.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    final DepartmentReponsitory departmentReponsitory;
    @Override
    public List<Department> getAllDepartment() {
        return departmentReponsitory.findAll();
    }

    @Override
    public Department getDepartmentById(int id) {
        Optional<Department> optional = departmentReponsitory.findById(id);

        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public Department createNewDepartment(DepartmentCreateRequestDto dto) {
        Department newDepartment = new Department();
        newDepartment.setDepartmentName(dto.getDepartmentName());
        newDepartment.setNumbers(dto.getNumbers());
        return departmentReponsitory.save(newDepartment);
    }

    @Override
    public Department updateDepartment(DepartmentUpdateRequestDto dto) {
        int id = dto.getId();
        Department department = getDepartmentById(id);
        if(department != null){
            department.setDepartmentName(dto.getName());
            return departmentReponsitory.save(department);
        }
        return null;
    }

    @Override
    public void deleteDepartmentById(int id) {
        departmentReponsitory.deleteById(id);
    }

    @Override
    public Page<Department> search(DepartmentSearchDto request) {
        Specification<Department> condition = DepartmentSpecification.buildCondition(request);
        Sort sort = null;
        if("ASC".equalsIgnoreCase(request.getSortType())){
            sort = Sort.by(request.getSortBy()).ascending();
        } else {
            sort = Sort.by(request.getSortBy()).descending();
        }

        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSize() , sort);
        Page<Department> page = departmentReponsitory.findAll(condition, pageable);
        return page;
    }

}
