package com.vti.bep3.dto;


import com.vti.bep3.entity.CustomerOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderUpdateDto {
    private Integer id;
    private Date createdAt;
    private CustomerOrder.CustomerOrderStatus status;
}
