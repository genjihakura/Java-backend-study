package com.vti.hello_world.modal;

import com.vti.hello_world.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionUpdateDto {
    int id;
    @NotNull(message = "vi tri khong de rong")
    Position.PositionName positionName;

}
