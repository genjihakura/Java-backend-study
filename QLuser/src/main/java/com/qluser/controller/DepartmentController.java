package com.qluser.controller;

import com.qluser.dto.request.*;
import com.qluser.entity.Department;
import com.qluser.entity.User;
import com.qluser.service.DepartmentService;
import com.qluser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
@CrossOrigin("http://127.0.0.1:5500")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @PostMapping("/search")
    public Page<Department> search(@RequestBody DepartmentSearchDto request){
        return departmentService.search(request);
    }

    @PostMapping("/create")
    public Department createDepartment(@RequestBody DepartmentCreateRequestDto dto){
        return departmentService.createNewDepartment(dto);
    }

    @PutMapping("/update")
    public Department updateUser(@RequestBody DepartmentUpdateRequestDto dto){
        return departmentService.updateDepartment(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id ){
        departmentService.deleteDepartmentById(id);
    }
}
