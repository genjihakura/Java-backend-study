package com.qluser.repository.specification;

import com.qluser.dto.request.DepartmentSearchDto;
import com.qluser.dto.request.UserSearchDto;
import com.qluser.entity.Department;
import com.qluser.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class DepartmentSpecification {
    public static Specification<Department> buildCondition(DepartmentSearchDto request){
        return Specification.where(buildName(request));
    }
    public static Specification<Department> buildName(DepartmentSearchDto request){
        if((request.getName() == null ) || request.getName().equalsIgnoreCase("")) return null;

        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("name"), "%" + request.getName() + "%");
        });
    }
}
