package com.qluser.service.Impl;

import com.qluser.dto.request.UserCreateRequestDto;
import com.qluser.dto.request.UserSearchDto;
import com.qluser.dto.request.UserUpdateRequestDto;
import com.qluser.entity.User;
import com.qluser.repository.UserReponsitory;
import com.qluser.repository.specification.UserSpecification;
import com.qluser.service.UserService;
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
public class UserServiceImpl implements UserService {

    final UserReponsitory userReponsitory;
    @Override
    public List<User> getAllUser() {
        return userReponsitory.findAll();
    }

    @Override
    public User getUserById(int id) {
        Optional<User> optional = userReponsitory.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public User createNewUser(UserCreateRequestDto dto) {
        User newUser = new User();
        newUser.setName(dto.getName());
        newUser.setEmail(dto.getEmail());
        newUser.setAvatar(dto.getAvatar());
        newUser.setDob(dto.getDob());
        return userReponsitory.save(newUser);
    }

    @Override
    public User updateUser(UserUpdateRequestDto dto) {
        int id = dto.getId();
        User user = getUserById(id);
        if(user != null){
            user.setName(dto.getName());
            user.setEmail(dto.getEmail());
            user.setAvatar(dto.getAvatar());
            user.setDob(dto.getDob());
            return userReponsitory.save(user);
        }
        return null;
    }

    @Override
    public void deleteUserById(int id) {
        userReponsitory.deleteById(id);
    }

    @Override
    public Page<User> Search(UserSearchDto request) {
        Specification<User> condition = UserSpecification.buildCondition(request);
        Sort sort = null;
        if("ASC".equalsIgnoreCase(request.getSortType())){
            sort = Sort.by(request.getSortBy()).ascending();
        } else {
            sort = Sort.by(request.getSortBy()).descending();
        }

        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSize() , sort);
        Page<User> page = userReponsitory.findAll(condition, pageable);
        return page;
    }

}
