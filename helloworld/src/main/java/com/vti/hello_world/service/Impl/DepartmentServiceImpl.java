package com.vti.hello_world.service.Impl;

import com.vti.hello_world.entity.Department;
import com.vti.hello_world.modal.DepartmentCreateDto;
import com.vti.hello_world.modal.DepartmentSearchDto;
import com.vti.hello_world.modal.DepartmentUpdateDto;
import com.vti.hello_world.repository.DepartmentRepository;
import com.vti.hello_world.repository.specification.DepartmentSpecification;
import com.vti.hello_world.service.DepartmentService;
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
    final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll(String departmentName){
//        return departmentRepository.findAll();
        return departmentRepository.findAllByDepartmentNameContains(departmentName);
    }

    public Page<Department> search(DepartmentSearchDto request){
        Specification<Department> condition = DepartmentSpecification.buildCondition(request);
// Tạo phân trang, sắp xếp
        Sort sort = null;
        if ("ASC".equalsIgnoreCase(request.getSortType())){
            sort = Sort.by(request.getSortBy()).ascending();
        } else {
            sort = Sort.by(request.getSortBy()).descending();
        }
// Tạo ra đối tượng Pageable có sắp xếp
        Pageable pageable = PageRequest.of(request.getPage()-1, request.getSize(), sort);
        Page<Department> page = departmentRepository.findAll(condition, pageable);
        return page;
    }

    @Override
    public Department create(DepartmentCreateDto dto) {
        Department checker = departmentRepository.findByDepartmentName(dto.getDepartmentName());
        if(checker != null){
            System.err.println("department exists");
            return null;
        }

        Department entity = new Department();
        entity.setDepartmentName(dto.getDepartmentName());
        return departmentRepository.save(entity);
    }

    @Override
    public Department update(DepartmentUpdateDto dto) {
        int id = dto.getId();
        Department entity = findById(id);
        if(entity != null){
            entity.setDepartmentName(dto.getDepartmentName());
            return departmentRepository.save(entity);
        }
        return null;
    }

    @Override
    public Department findById(int id) {
        Optional<Department> optional = departmentRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public void deleteBy(int id) {
        departmentRepository.deleteById(id);
    }

}
