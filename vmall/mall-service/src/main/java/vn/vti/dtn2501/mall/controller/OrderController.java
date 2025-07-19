package vn.vti.dtn2501.mall.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vti.dtn2501.common.api.response.ApiResponse;
import vn.vti.dtn2501.mall.entity.OrderUser;
import vn.vti.dtn2501.mall.payload.request.CreateOrderRequest;
import vn.vti.dtn2501.mall.service.IOrderService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private  final IOrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<ApiResponse<OrderUser>> createOrder( @RequestBody CreateOrderRequest request) {
        return new ResponseEntity<>(ApiResponse.success(orderService.createOrder(request)), HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderUser>> getALlOrdersByUser(@PathVariable Long userId) {
        List<OrderUser> orders = orderService.getOrdersByUser(userId);
        return ResponseEntity.ok(orders);
    }
}
