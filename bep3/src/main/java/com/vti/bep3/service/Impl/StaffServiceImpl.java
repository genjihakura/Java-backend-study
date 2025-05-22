package com.vti.bep3.service.Impl;

import com.vti.bep3.entity.Staff;
import com.vti.bep3.responsitory.StaffRepository;
import com.vti.bep3.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StaffServiceImpl implements StaffService, UserDetailsService {
    final StaffRepository staffRepository;

    @Override
    public StaffService create(StaffService staffService) {
        return null;
    }

    @Override
    public StaffService update(StaffService staffService) {
        return null;
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
