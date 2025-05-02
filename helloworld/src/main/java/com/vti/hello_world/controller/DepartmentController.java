package com.vti.hello_world.controller;

import com.vti.hello_world.entity.Department;
import com.vti.hello_world.modal.DepartmentCreateDto;
import com.vti.hello_world.modal.DepartmentSearchDto;
import com.vti.hello_world.modal.DepartmentUpdateDto;
import com.vti.hello_world.repository.specification.DepartmentSpecification;
import com.vti.hello_world.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PrePersist;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
@Validated
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public List<Department> getAll(@RequestParam String  departmentName ){
        return departmentService.getAll(departmentName);
    }

    @PostMapping("/search")
    public Page<Department> search(@RequestBody DepartmentSearchDto request) {
        return departmentService.search(request);
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid DepartmentCreateDto department) {
        return ResponseEntity.ok(departmentService.create(department));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid DepartmentUpdateDto dto) {
        return ResponseEntity.ok(departmentService.update(dto));
    }

    @GetMapping("/find/{id}")
    public Department findById(@PathVariable int id) {
        return departmentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        departmentService.deleteBy(id);
    }

}
