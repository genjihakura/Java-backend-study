package com.vti.hello_world.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DepartmentCreateDto {
    @NotBlank(message = "Ten phong ban ko de trong")
    @Length(max = 50, message = "Ten phong ban khong duoc qua 50 ky tu")
    private String departmentName;
}
