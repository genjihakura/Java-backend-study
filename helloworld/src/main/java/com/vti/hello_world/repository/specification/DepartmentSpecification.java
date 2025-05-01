package com.vti.hello_world.repository.specification;

import com.vti.hello_world.entity.Department;
import com.vti.hello_world.modal.DepartmentSearchDto;
import com.vti.hello_world.utils.SpecificationCustom;
import org.springframework.data.jpa.domain.Specification;

public class DepartmentSpecification {

    public static Specification<Department> buildCondition(DepartmentSearchDto request){

        SpecificationCustom<Department>  specificationCustom = new SpecificationCustom<>();

        return Specification.where(specificationCustom.like("departmentName" , request.getName()))
                .and(specificationCustom.greaterThanOrEqualDate("fromDate", request.getFromDate()))
                .and(specificationCustom.lessThanOrEqualDate("toDate", request.getFromDate()));
    }

}
