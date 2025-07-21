package vn.vti.dtn2501.mall.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vti.dtn2501.common.api.response.ApiResponse;
import vn.vti.dtn2501.mall.client.UserClient;
import vn.vti.dtn2501.mall.entity.users.UserDto;
import vn.vti.dtn2501.mall.payload.request.CreateOrderRequest;
import vn.vti.dtn2501.mall.payload.response.CreateOrderResponse;
import vn.vti.dtn2501.mall.service.IOrderService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private final IOrderService orderService;
    private final UserClient userClient;

    @PostMapping("/order")
    public ResponseEntity<ApiResponse<CreateOrderResponse>> createOrder(@RequestBody CreateOrderRequest request) {
        return new ResponseEntity<>(ApiResponse.success(orderService.createOrder(request)), HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<UserDto>> getUserById(@PathVariable Long userId) {
//        List<OrderUser> orders = orderService.getOrdersByUser(userId);
        UserDto user = userClient.getUserById(userId);
        return new ResponseEntity<>(ApiResponse.success(user), HttpStatus.OK);
    }

}
