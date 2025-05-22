package com.vti.bep3.controller;

import com.vti.bep3.entity.AccountLoginDto;
import com.vti.bep3.entity.Staff;
import com.vti.bep3.responsitory.StaffRepository;
import com.vti.bep3.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login-jwt")
    public ResponseEntity<?> loginJwt(@RequestParam String userName, @RequestParam String password, HttpServletRequest httpServletRequest) {
        Optional<Staff> optional = staffRepository.findByUserName(userName);
        if (optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("User name không tồn tại trong hệ thống!");
        }
        Staff account = optional.get();
        if (!passwordEncoder.matches(password, account.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Sai pasword!");
        }

        String token = JwtUtils.createToken(account, httpServletRequest);

        AccountLoginDto dto = new AccountLoginDto();
        dto.setMail(account.getEmail());
        dto.setUserName(account.getUserName());
        dto.setToken(token);
        return ResponseEntity.ok(dto);
    }
}
