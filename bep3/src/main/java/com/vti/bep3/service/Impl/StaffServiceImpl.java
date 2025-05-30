package com.vti.bep3.service.Impl;

import com.vti.bep3.config.ConfigBean;
import com.vti.bep3.dto.StaffCreateDto;
import com.vti.bep3.dto.StaffUpdateDto;
import com.vti.bep3.entity.Staff;
import com.vti.bep3.exception.LogicCustomException;
import com.vti.bep3.responsitory.StaffRepository;
import com.vti.bep3.service.StaffService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StaffServiceImpl implements StaffService, UserDetailsService {
    final StaffRepository staffRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public Staff create(StaffCreateDto dto) {
        Optional<Staff> optional = staffRepository.findByUserName(dto.getUserName());

        if (optional.isPresent()){
            System.err.println("Username đã tồn tại");
            LogicCustomException exception = new LogicCustomException();
            exception.setCode(500);
            exception.setMessage("Username đã tồn tại");
            throw exception;
        }
        Staff entity = new Staff();
        entity.setFullname(dto.getFullname());
        entity.setUserName(dto.getUserName());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setEmail(dto.getEmail());
        entity.setRole(dto.getRole());
        entity.setStatus(dto.getStatus());
        staffRepository.save(entity);
        return entity;
    }

    @Override
    public Staff update(StaffUpdateDto dto) {
        Optional<Staff> optional = staffRepository.findById(dto.getId());

        if (optional.isEmpty()){
            System.err.println("Username không tồn tại");
            LogicCustomException exception = new LogicCustomException();
            exception.setCode(500);
            exception.setMessage("Username không tồn tại");
            throw exception;
        }
        Staff entity = optional.get();
        entity.setFullname(dto.getFullname());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setRole(dto.getRole());
        entity.setStatus(dto.getStatus());
        staffRepository.save(entity);
        return entity;
    }

    public void saveFileData(InputStream file) throws IOException {
//        List<Staff> staffList = new LinkedList<>();
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);

        sheet.forEach(row -> {
            Staff entity = new Staff();

            if (row.getRowNum() != 0) {
                entity.setFullname(row.getCell(0).getStringCellValue());
                entity.setEmail(row.getCell(1).getStringCellValue());
                entity.setUserName(row.getCell(2).getStringCellValue());
                String password =  row.getCell(3).getStringCellValue();
                entity.setPassword(passwordEncoder.encode(password) );
                Staff.Role role = row.getCell(4).getStringCellValue().equals("ADMIN") ? Staff.Role.ADMIN : Staff.Role.EMPLOYEE;
                entity.setRole(role);
                Staff.Status status = row.getCell(5).getStringCellValue().equals("ACTIVE") ? Staff.Status.ACTIVE : Staff.Status.IN_ACTIVE;
                entity.setStatus(status);
                staffRepository.save(entity);
            }
        });

//        staffRepository.saveAll(staffList);

    }

    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        staffRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Staff> optional = staffRepository.findByUserName(username);
        if (optional.isEmpty()){
            throw new UsernameNotFoundException(username);
        }
        // Nếu có thôgn tin người dung, lấy các giá trị userName, password, danh sách quyền của người dùng
        // để khởi tạo
        Staff account = optional.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        // C1:
        Staff.Role role = account.getRole();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());

        authorities.add(authority);

        return new User(account.getUserName(), account.getPassword(), authorities);
    }


}
