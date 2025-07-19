package vn.vti.dtn2501.mall.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCartItemResponse {
    private Long cartId;
    private Long productId;
    private String productName;
    private BigDecimal productPrice;
    private Long quantity;
}
