package com.vti.hello_world.modal;

import com.vti.hello_world.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionCreateDto {
    Position.PositionName PositionName;
}
