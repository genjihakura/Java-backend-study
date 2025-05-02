package com.qluser.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentSearchDto {
    private String name;

    private int page;
    private int size;
    private String sortBy = "id";
    private String sortType = "DESC";
}
