package com.vti.bep3.dto;

import com.vti.bep3.entity.CustomerOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderCreateDto {
    private List<OrderItemDto> items;
    @Data
    public static class OrderItemDto{
        private Integer menuItemId;
        private Integer quantity;
    }
}
