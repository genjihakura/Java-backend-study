package com.vti.hello_world.modal;

import com.vti.hello_world.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionUpdateDto {
    int id;
    Position.PositionName PositionName;

}
