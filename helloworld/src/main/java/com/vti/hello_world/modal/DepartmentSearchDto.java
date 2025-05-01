package com.vti.hello_world.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentSearchDto {
    private String name;
    private Date fromDate;
    private Date toDate;

    private int page;
    private int size;
    private String sortBy = "id";
    private String sortType = "DESC";
}
