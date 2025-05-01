package com.vti.hello_world.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    int accountId;
    String email;
    String userName;
    String fullName;
    int departnameId;
    int positionId;
    Date CreateDate;

}
