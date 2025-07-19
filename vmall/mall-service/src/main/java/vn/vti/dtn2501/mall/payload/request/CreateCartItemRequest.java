package vn.vti.dtn2501.mall.payload.request;

import lombok.Data;

@Data
public class CreateCartItemRequest {
    private Long productId;
    private Long quantity;
    private Long cartId;
}
