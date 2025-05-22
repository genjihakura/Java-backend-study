package com.vti.bep3.service.Impl;

import com.vti.bep3.responsitory.OrderItemRepository;
import com.vti.bep3.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    final OrderItemRepository orderRepository;

    @Override
    public OrderItemService create(OrderItemService orderItemService) {
        return null;
    }

    @Override
    public OrderItemService update(OrderItemService orderItemService) {
        return null;
    }
}
