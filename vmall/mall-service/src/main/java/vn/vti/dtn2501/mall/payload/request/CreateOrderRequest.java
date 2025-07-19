package vn.vti.dtn2501.mall.payload.request;

import lombok.Data;

@Data
public class CreateOrderRequest {
    private Long userId;
    private Long cartId;
    private String shippingAddress;
    private String paymentMethod;
}
