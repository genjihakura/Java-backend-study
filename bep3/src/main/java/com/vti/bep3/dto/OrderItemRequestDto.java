package com.vti.bep3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequestDto {
    private Integer id;
    private Integer orderId;
    private Integer menuItemId;
    private Integer quantity;
}
