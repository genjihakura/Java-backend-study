package vn.vti.dtn2501.mall.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import vn.vti.dtn2501.mall.entity.Cart;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCartRequest {
    private Long id;
    private Long userId;
    private Cart.Status Status;
}
