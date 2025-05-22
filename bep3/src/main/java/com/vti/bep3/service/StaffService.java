package com.vti.bep3.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface StaffService extends UserDetailsService {
    StaffService create(StaffService staffService);
    StaffService update(StaffService staffService);
    void deleteById(int id);
}
