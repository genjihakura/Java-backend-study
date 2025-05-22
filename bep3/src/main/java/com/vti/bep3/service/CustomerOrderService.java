package com.vti.bep3.service;

import com.vti.bep3.dto.CustomerOrderCreateDto;
import com.vti.bep3.dto.CustomerOrderUpdateDto;
import com.vti.bep3.entity.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {
    List<CustomerOrder> getAllOrders();
    CustomerOrder create(CustomerOrderCreateDto dto);
    CustomerOrder update(CustomerOrderUpdateDto dto);
    CustomerOrder updateOrder(int id, CustomerOrderCreateDto dto);
    void deleteById(int id);
}
