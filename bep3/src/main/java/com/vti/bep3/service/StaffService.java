package com.vti.bep3.service;

import com.vti.bep3.dto.StaffCreateDto;
import com.vti.bep3.dto.StaffUpdateDto;
import com.vti.bep3.entity.Staff;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface StaffService extends UserDetailsService {
    Staff create(StaffCreateDto dto);
    Staff update(StaffUpdateDto dto);
    List<Staff> findAll();
    void saveFileData(InputStream file) throws IOException;
    void deleteById(int id);
}
