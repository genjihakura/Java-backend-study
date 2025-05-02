package com.qluser.service;

import com.qluser.dto.request.UserCreateRequestDto;
import com.qluser.dto.request.UserSearchDto;
import com.qluser.dto.request.UserUpdateRequestDto;
import com.qluser.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public User getUserById(int id);
    public User createNewUser(UserCreateRequestDto user);
    public User updateUser(UserUpdateRequestDto user);
    public void deleteUserById(int id);
    public Page<User> Search(UserSearchDto user);
}
