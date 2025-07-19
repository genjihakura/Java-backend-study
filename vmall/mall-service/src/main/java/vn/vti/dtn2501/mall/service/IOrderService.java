package vn.vti.dtn2501.mall.service;


import vn.vti.dtn2501.mall.entity.OrderUser;
import vn.vti.dtn2501.mall.payload.request.CreateOrderRequest;

import java.util.List;

public interface IOrderService {
    OrderUser createOrder(CreateOrderRequest request);
    OrderUser getOrderById(Long orderId);
    List<OrderUser> getOrdersByUser(Long userId);
    OrderUser updateOrderStatus(Long orderId, String status);
}
