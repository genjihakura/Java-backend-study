package vn.vti.dtn2501.mall.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.vti.dtn2501.mall.entity.Cart;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCartResponse {
    private Long id;
    private Long userId;
    private Cart.Status Status;
}
