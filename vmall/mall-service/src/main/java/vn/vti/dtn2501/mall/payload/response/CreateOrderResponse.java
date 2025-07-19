package vn.vti.dtn2501.mall.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderResponse {
    private Long id;
    private Long userId;
    private Long cartId;
    private BigDecimal totalAmount;
    private String shippingAddress;
    private String paymentMethod;
    private String status;
    private Data createdAt;
}
