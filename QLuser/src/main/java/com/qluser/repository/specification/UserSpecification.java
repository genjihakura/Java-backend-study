package com.qluser.repository.specification;

import com.qluser.dto.request.UserSearchDto;
import com.qluser.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    public static Specification<User> buildCondition(UserSearchDto request){
        return Specification.where(buildName(request))
                .and(buildEmail(request))
                .and(fromDoB(request))
                .and(toDoB(request));
    }
    public static Specification<User> buildName(UserSearchDto request){
        if((request.getName() == null ) || request.getName().equalsIgnoreCase("")) return null;

        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("name"), "%" + request.getName() + "%");
        });
    }
    public static Specification<User> buildEmail(UserSearchDto request){
        if((request.getEmail() == null ) || request.getEmail().equalsIgnoreCase("")) return null;

        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("email"), "%" + request.getEmail() + "%");
        });
    }

    public static Specification<User> fromDoB(UserSearchDto request){
        if(request.getFromDoB() == null) return null;

        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.greaterThanOrEqualTo(root.get("dob"), request.getFromDoB());
        });
    }
    public static Specification<User> toDoB(UserSearchDto request){
        if(request.getToDoB() == null) return null;

        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.lessThanOrEqualTo(root.get("dob"), request.getToDoB());
        });
    }

}
