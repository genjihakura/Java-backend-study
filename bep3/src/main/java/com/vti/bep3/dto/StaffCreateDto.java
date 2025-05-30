package com.vti.bep3.dto;

import com.vti.bep3.entity.Staff;
import lombok.Data;

@Data
public class StaffCreateDto {
    private String userName;
    private String password;
    private String Fullname;
    private String email;
    private Staff.Role role;
    public enum Role {
        ADMIN, EMPLOYEE;
    }

    private Staff.Status Status;
    public enum Status {
        ACTIVE, IN_ACTIVE
    }
}
