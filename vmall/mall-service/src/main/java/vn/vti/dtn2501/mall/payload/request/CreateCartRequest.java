package vn.vti.dtn2501.mall.payload.request;

import lombok.Data;
import vn.vti.dtn2501.mall.entity.Cart;

@Data
public class CreateCartRequest {
    private Long userId;
}
