package com.vti.bep3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemCreateDto {
    private String name;
    private Double price;
    private String imageMenu;
    private String description;
}
