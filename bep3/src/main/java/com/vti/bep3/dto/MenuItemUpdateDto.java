package com.vti.bep3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemUpdateDto {
    private Integer id;
    private String name;
    private Double price;
    private Integer numberAvailable;
    private Date createDate;
    private Date updateDate;
}
