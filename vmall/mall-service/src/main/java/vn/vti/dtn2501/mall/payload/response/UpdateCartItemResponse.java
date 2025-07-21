package vn.vti.dtn2501.mall.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCartItemResponse {
    private Long cartId;
    private Long productId;
    private Long quantity;
}
