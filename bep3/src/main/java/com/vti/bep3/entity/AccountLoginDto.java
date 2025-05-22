package com.vti.bep3.entity;

import lombok.Data;

@Data
public class AccountLoginDto {
    private String userName;
    private String mail;
    //...
    private String token;
}
