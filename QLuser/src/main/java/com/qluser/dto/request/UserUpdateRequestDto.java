package com.qluser.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequestDto {
    private int id;
    private String name;
    private String avatar;
    private String email;
    private Date Dob;
}
