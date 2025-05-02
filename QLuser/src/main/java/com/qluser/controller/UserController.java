package com.qluser.controller;

import com.qluser.dto.request.UserCreateRequestDto;
import com.qluser.dto.request.UserSearchDto;
import com.qluser.dto.request.UserUpdateRequestDto;
import com.qluser.entity.User;
import com.qluser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("http://127.0.0.1:5500")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/search")
    public Page<User> createUser(@RequestBody UserSearchDto request){
        return userService.Search(request);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody UserCreateRequestDto dto){
        return userService.createNewUser(dto);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody UserUpdateRequestDto dto){
        return userService.updateUser(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id ){
         userService.deleteUserById(id);
    }
}
