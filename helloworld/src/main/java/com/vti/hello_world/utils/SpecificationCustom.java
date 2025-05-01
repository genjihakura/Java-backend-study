package com.vti.hello_world.utils;

import com.vti.hello_world.entity.Department;
import com.vti.hello_world.modal.DepartmentSearchDto;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class SpecificationCustom<E>{

    public Specification<E> like(String key, String value){
        if(value == null || value.equals("")) return null;

        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(key), "%" + value + "%");
        });
    }

    public Specification<E> greaterThanOrEqualDate(String key, Date date){
        if(date == null) return null;

        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.greaterThanOrEqualTo(root.get(key),date);
        });
    }

    public Specification<E> lessThanOrEqualDate(String key, Date date){
        if(date == null) return null;

        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.lessThanOrEqualTo(root.get(key),date);
        });
    }
}
